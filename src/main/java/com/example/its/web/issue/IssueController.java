package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
//final付与されているfieldかつ初期化されていないコンストラクタを自動生成する
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService ;
    //Get/issues
    @GetMapping("/issues")
    public String showList(Model model){ //メソッドの呼び出し時にSpringからModelのインスタンスを呼び出すことができる
        //Thymeleafにオブジェクトを渡すことができるメソッド
        //第1引数：Thymeleafで参照する際のkey,第2引数はThymeleafに渡したいオブジェクト
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

}
