package com.example.its.web;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class IndexController {
    @GetMapping//("/")省略可
    public String index(){
        return "index";//SpringMVCの機能により拡張子は不要
    }
}
