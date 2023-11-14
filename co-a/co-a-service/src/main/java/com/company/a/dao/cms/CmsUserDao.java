package com.company.a.dao.cms;

import com.company.a.entity.CmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户表(CmsUser)表数据库访问层
 *
 * @author Jerry
 * @since 2023-04-06 17:01:48
 */
@Mapper
public interface CmsUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CmsUser queryById(Integer id);

    List<CmsUser> queryList(String account);

    /**
     * 查询指定行数据
     *
     * @param cmsUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CmsUser> queryAllByLimit(CmsUser cmsUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cmsUser 查询条件
     * @return 总行数
     */
    long count(CmsUser cmsUser);

    /**
     * 新增数据
     *
     * @param cmsUser 实例对象
     * @return 影响行数
     */
    int insert(CmsUser cmsUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CmsUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CmsUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CmsUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CmsUser> entities);

    /**
     * 修改数据
     *
     * @param cmsUser 实例对象
     * @return 影响行数
     */
    int update(CmsUser cmsUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void updateTest();

}

