package com.example.blog.post;


import io.swagger.annotations.*;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.*;

import com.example.blog.HttpRequest;

import static org.springframework.http.ResponseEntity.status;



@RestController
@RequestMapping(value="/api")
public class PostController {



    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<Object> Ping(){
      try {
          Map<String, Object> map = new HashMap<>();
          map.put("success", true);
          HttpStatus ok = HttpStatus.OK;
          return new ResponseEntity<>(map, ok);
      }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity<>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @ApiResponses(value={
            @ApiResponse( code= 400, message = "Tags parameter is required" )
    })
    @GetMapping("/posts")
    public ResponseEntity<?> getPostsWTags(@RequestParam("tag") String tag){
            String ending = "?tag=" + tag;
            String baseUrl = "https://api.hatchways.io/assessment/blog/posts";

            try{
            HttpRequest request = HttpRequest.get(baseUrl + ending).connectTimeout(12000);
            String res = request.body();
            return new ResponseEntity<>(res,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!,please try again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}