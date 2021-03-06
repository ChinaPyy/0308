package com.example.edu.utlis;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.edu.entity.Subject;
import com.example.edu.entity.excel.SubjectData;
import com.example.edu.service.SubjectService;
import com.example.handler.GuliException;

import java.util.Map;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/14 13:48
 **/
public class SubjectReadListener extends AnalysisEventListener<SubjectData> {
    public SubjectService subjectService;

    public SubjectReadListener() {
    }
    //创建有参数构造，传递subjectService用于操作数据库

    public SubjectReadListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    //一行一行去读取excle内容

    @Override
    public void invoke(SubjectData user, AnalysisContext analysisContext) {

        if (user == null) {
            throw new GuliException(20001, "添加失败");
        }
        //添加一级分类
        Subject existOneSubject = this.existOneSubject(subjectService, user.getOneSubjectName());
        if (existOneSubject == null) {//没有相同的
            existOneSubject = new Subject();
            existOneSubject.setTitle(user.getOneSubjectName());
            existOneSubject.setParentId("0");
            subjectService.save(existOneSubject);
        }
        //获取一级分类id值
        String pid = existOneSubject.getId();

        //添加二级分类
        Subject existTwoSubject = this.existTwoSubject(subjectService, user.getTwoSubjectName(), pid);
        if (existTwoSubject == null) {
            existTwoSubject = new Subject();
            existTwoSubject.setTitle(user.getTwoSubjectName());
            existTwoSubject.setParentId(pid);
            subjectService.save(existTwoSubject);
        }
    }

    //读取excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {

        System.out.println("表头信息：" + headMap);
    }
    //读取完成后执行

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    //判断一级分类是否重复
    private Subject existTwoSubject(SubjectService subjectService, String name, String pid) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        Subject sub = subjectService.getOne(wrapper);
        return sub;
    }

    //判断一级分类是否重复
    private Subject existOneSubject(SubjectService subjectService, String name) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        Subject subject = subjectService.getOne(wrapper);
        return subject;
    }
}
