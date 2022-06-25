package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService ;
    //Get/issues
    @GetMapping
    public String showList(Model model){
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        return "/issues/creationForm";//resources/templatesからの相対パスを記載(拡張子は書かない)
    }
    //POST/issues
    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model){
        //BindingResult bindingResultは@Validatedのすぐ後ろに追加する必要あり
        if(bindingResult.hasErrors()){
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription()) ;
            return "redirect:/issues";
    }
    //Get localhost:8080/issues/1,2,3・・・
    @GetMapping("/{issueId}")//動的に変わるパス(/1)を扱うため
    public String showDetail(@PathVariable("issueId") long issueId, Model model){
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";//ビュー名を指定
    }
}

