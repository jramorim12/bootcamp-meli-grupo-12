package br.com.marcello.ApiCasa.controllers;

import br.com.marcello.ApiCasa.utils.HomeUtils;
import org.apache.commons.io.IOUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class HomeController {

    @Autowired
    private HomeUtils homeUtils;

    @PostMapping("/api/home")
    public void getHomeJson(HttpServletRequest request, HttpServletResponse response) {

        JSONObject homeJson;
        try{
            String bodyString = IOUtils.toString(request.getReader());
            homeJson = new JSONObject(bodyString);
        } catch (IOException | JSONException e) {
            throw new RuntimeException("Impossible to read body request and create JSON", e);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject responseHomeJson = this.homeUtils.getFinalHomeJson(homeJson);

        try(PrintWriter responseWriter = response.getWriter()) {
            responseWriter.print(responseHomeJson);
            responseWriter.flush();
        } catch (IOException e) {
            response.setStatus(500);
            throw new RuntimeException("Impossible to set response body", e);
        }

    }

}
