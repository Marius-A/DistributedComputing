package com.mariusiliescu.cloudcomputing.web;

import com.mariusiliescu.cloudcomputing.model.Task;
import com.mariusiliescu.cloudcomputing.model.User;
import com.mariusiliescu.cloudcomputing.service.TaskService;
import com.mariusiliescu.cloudcomputing.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class FileUploadController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HttpServletRequest request;



    @RequestMapping(value = "/add_task", method = RequestMethod.GET)
    public String addTaskGet(){
        return "add_task";
    }


    @RequestMapping(value = "/add_task_code", method = RequestMethod.POST)
    public String addTaskCode(@RequestParam(value = "code", required = false) String code,
                              @RequestParam(value = "dificultyc", required = false) int dificulty,
                              HttpSession session) {
        //Todo create task
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        if (!code.isEmpty()) {
            try {
                User loggedUser = userService.findByUsername(name);
                Task task = new Task(dificulty,loggedUser);
                Long taskId = taskService.save(task);
                task.setTaskId(taskId);
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date currentDate = new Date();
                try {
                    task.setDateAdded(formatter.parse(formatter.format(currentDate)));
                } catch (ParseException e) {}

                loggedUser.addTask(task);

                String filename= new String("code");
                filename = filename.concat(taskId+".js");
                System.out.print("filename:  "+filename);

                String uploadsDir = "/uploads/";
                String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdir();
                }


                File file = new File(realPathtoUploads+"/"+filename);
                FileUtils.writeStringToFile(file,code);
                System.out.print(file.getAbsolutePath());

                User user = null;
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                user = userService.findByUsername(username);
                session.setAttribute("loggedInUser", user);


            } catch (RuntimeException | IOException re) {
                //bindingResult.rejectValue("errfile", "messageCode", "No file inserted");
                //// TODO: 03.06.2016  remove task
                System.out.print("runtime ex");
                return "redirect:add_task";
            }
        }
        return "add_task";
    }


    @RequestMapping(value = "/add_task_file", method = RequestMethod.POST)
    public String addTaskFile(@RequestParam(value = "file", required = false) MultipartFile code,
                              @RequestParam(value = "dificulty", required = false) int dificulty,
                              HttpSession session) {
        //Todo create task
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        if (!code.isEmpty()) {
            try {
                validateFile(code);
                User loggedUser = userService.findByUsername(name);
                Task task = new Task(dificulty,loggedUser);
                Long taskId = taskService.save(task);
                task.setTaskId(taskId);
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date currentDate = new Date();
                try {
                    task.setDateAdded(formatter.parse(formatter.format(currentDate)));
                } catch (ParseException e) {}
                loggedUser.addTask(task);

                String filename= new String("code");
                filename = filename.concat(taskId+".js");
                System.out.print("filename:  "+filename);
                saveCode(filename,code);

                User user = null;
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                user = userService.findByUsername(username);

                session.setAttribute("loggedInUser", user);
            } catch (RuntimeException re) {
                //bindingResult.rejectValue("errfile", "messageCode", "No file inserted");
                System.out.print("runtime ex");
                return "redirect:add_task";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/add_task";
    }

    private void validateFile(MultipartFile image) {
        System.out.println("Type:"+ image.getContentType());
        if (!image.getContentType().equals("application/javascript")) {
            throw new RuntimeException("Only JS images are accepted");
        }
    }

    private void saveCode(String filename, MultipartFile code)
            throws RuntimeException, IOException {
        try {
            String uploadsDir = "/uploads/";
            String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
            if(! new File(realPathtoUploads).exists())
            {
                new File(realPathtoUploads).mkdir();
            }


            File file = new File(realPathtoUploads+"/"+filename);

            FileUtils.writeByteArrayToFile(file, code.getBytes());
            System.out.println("Go to the location:  " + file.toString()
                    + " on your computer and verify that the code has been stored.");
        } catch (IOException e) {
            throw e;
        }
    }
}