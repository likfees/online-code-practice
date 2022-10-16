package cn.lzscxb.business.service.impl;

import java.util.List;
import cn.lzscxb.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.lzscxb.business.mapper.FengProblemCommentMapper;
import cn.lzscxb.domain.entity.FengProblemComment;
import cn.lzscxb.business.service.IFengProblemCommentService;

/**
 * 题目评论Service业务层处理
 * 
 * @author Likfees
 * @date 2022-10-16
 */
@Service
public class FengProblemCommentServiceImpl implements IFengProblemCommentService 
{
    @Autowired
    private FengProblemCommentMapper fengProblemCommentMapper;

    /**
     * 查询题目评论
     * 
     * @param id 题目评论主键
     * @return 题目评论
     */
    @Override
    public FengProblemComment selectFengProblemCommentById(Long id)
    {
        return fengProblemCommentMapper.selectFengProblemCommentById(id);
    }

    /**
     * 查询题目评论列表
     * 
     * @param fengProblemComment 题目评论
     * @return 题目评论
     */
    @Override
    public List<FengProblemComment> selectFengProblemCommentList(FengProblemComment fengProblemComment)
    {
        return fengProblemCommentMapper.selectFengProblemCommentList(fengProblemComment);
    }

    /**
     * 新增题目评论
     * 
     * @param fengProblemComment 题目评论
     * @return 结果
     */
    @Override
    public int insertFengProblemComment(FengProblemComment fengProblemComment)
    {
        fengProblemComment.setCreateTime(DateUtils.getNowDate());
        return fengProblemCommentMapper.insertFengProblemComment(fengProblemComment);
    }

    /**
     * 修改题目评论
     * 
     * @param fengProblemComment 题目评论
     * @return 结果
     */
    @Override
    public int updateFengProblemComment(FengProblemComment fengProblemComment)
    {
        fengProblemComment.setUpdateTime(DateUtils.getNowDate());
        return fengProblemCommentMapper.updateFengProblemComment(fengProblemComment);
    }

    /**
     * 批量删除题目评论
     * 
     * @param ids 需要删除的题目评论主键
     * @return 结果
     */
    @Override
    public int deleteFengProblemCommentByIds(Long[] ids)
    {
        return fengProblemCommentMapper.deleteFengProblemCommentByIds(ids);
    }

    /**
     * 删除题目评论信息
     * 
     * @param id 题目评论主键
     * @return 结果
     */
    @Override
    public int deleteFengProblemCommentById(Long id)
    {
        return fengProblemCommentMapper.deleteFengProblemCommentById(id);
    }
}
