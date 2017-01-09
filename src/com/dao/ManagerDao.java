package com.dao;

import com.entity.Article;
import com.entity.Manager;
import com.entity.Nav;

import java.util.List;

/**
 * Created by junlai on 2017/1/5.
 */
public interface ManagerDao {
    public boolean insertManager(Manager manager);

    public void deleteManager(Manager manager);

    public boolean updateManagerPwd(Manager manager);

    public boolean updateManagerName(Manager manager);

    public boolean updateManagerNameAndPwd(Manager manager);

    public Manager queryManagerById(String manager_id);

    public List<Manager> queryManagerAll();

    public Manager queryManagerByIdAndPwd(Manager manager);

    public boolean insertNav(Nav nav);

    public List<Nav> queryNavAll();

    public Nav queryNavById(String nav_id);

    public boolean updateNav(Nav nav);

    public void deleteNav(Nav nav);

    public List<Article> queryArticleByNav_id(String nav_id);

}