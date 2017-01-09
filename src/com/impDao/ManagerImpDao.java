package com.impDao;

import com.dao.ManagerDao;
import com.db.Conn;
import com.entity.Article;
import com.entity.Manager;
import com.entity.Nav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by junlai on 2017/1/5.
 */
public class ManagerImpDao implements ManagerDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Statement statement = null;

    @Override
    public boolean insertManager(Manager manager) {
        connection = Conn.getCon();
        String sql = "insert into manager(manager_id,manager_name,manager_pwd)values(?,?,?)";
        Boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager.getManager_id());
            preparedStatement.setString(2, manager.getManager_name());
            preparedStatement.setString(3, manager.getManager_pwd());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean updateManagerName(Manager manager) {
        connection = Conn.getCon();
        String sql = "update manager set manager_name=? where manager_id=?";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager.getManager_name());
            preparedStatement.setString(2, manager.getManager_id());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateManagerPwd(Manager manager) {
        connection = Conn.getCon();
        String sql = "update  manager set manager_pwd=? where manager_id=?";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager.getManager_pwd());
            preparedStatement.setString(2, manager.getManager_id());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void deleteManager(Manager manager) {
        connection = Conn.getCon();
        String sql = "delete from manager where manager_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager.getManager_id());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Manager queryManagerById(String manager_id) {
        connection = Conn.getCon();
        String sql = "select manager_id,manager_name,manager_pwd from manager where manager_id=?";
        Manager manager = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                manager = new Manager();
                manager.setManager_id(resultSet.getString("manager_id"));
                manager.setManager_name(resultSet.getString("manager_name"));
                manager.setManager_pwd(resultSet.getString("manager_pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public boolean updateManagerNameAndPwd(Manager manager) {
        connection = Conn.getCon();
        String sql = "update manager set manager_name=? , manager_pwd=? where manager_id=?";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager.getManager_name());
            preparedStatement.setString(2, manager.getManager_pwd());
            preparedStatement.setString(3, manager.getManager_id());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Manager> queryManagerAll() {
        connection = Conn.getCon();
        List<Manager> list = new ArrayList();
        String sql = "select manager_id , manager_name from manager ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setManager_id(resultSet.getString("manager_id"));
                manager.setManager_name(resultSet.getString("manager_name"));

                list.add(manager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Manager queryManagerByIdAndPwd(Manager manager1) {
        connection = Conn.getCon();
        String sql = "select manager_id ,manager_pwd from manager where manager_id=? and manager_pwd=?";
        Manager manager = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manager1.getManager_id());
            preparedStatement.setString(2, manager1.getManager_pwd());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                manager = new Manager();
                manager.setManager_id(resultSet.getString("manager_id"));
                manager.setManager_pwd(resultSet.getString("manager_pwd"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return manager;
    }

    @Override
    public boolean insertNav(Nav nav) {
        connection = Conn.getCon();
        String sql = "insert into nav(nav_id,nav_name,nav_weight)values(?,?,?)";
        Boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nav.getNav_id());
            preparedStatement.setString(2, nav.getNav_name());
            preparedStatement.setInt(3, nav.getNav_weight());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Nav> queryNavAll() {
        connection = Conn.getCon();
        List<Nav> list = new ArrayList();
        String sql = "select nav_id , nav_name,nav_weight from nav ORDER BY nav_weight ASC ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Nav nav = new Nav();
                nav.setNav_id(resultSet.getString("nav_id"));
                nav.setNav_name(resultSet.getString("nav_name"));
                nav.setNav_weight(resultSet.getInt("nav_weight"));
                list.add(nav);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public Nav queryNavById(String nav_id) {
        connection = Conn.getCon();
        String sql = "select nav_id,nav_name,nav_weight from nav where nav_id=? limit 0,1 ";
        Nav nav1 = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nav_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nav1 = new Nav();
                nav1.setNav_id(resultSet.getString("nav_id"));
                nav1.setNav_name(resultSet.getString("nav_name"));
                nav1.setNav_weight(resultSet.getInt("nav_weight"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nav1;
    }

    @Override
    public boolean updateNav(Nav nav) {
        connection = Conn.getCon();
        String sql = "update nav set nav_name=? ,nav_weight=? where nav_id=? ";
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nav.getNav_name());
            preparedStatement.setInt(2, nav.getNav_weight());
            preparedStatement.setString(3, nav.getNav_id());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public void deleteNav(Nav nav) {
        connection = Conn.getCon();
        String sql = "delete from nav where nav_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nav.getNav_id());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Article> queryArticleByNav_id(String nav_id) {
        connection = Conn.getCon();
        String sql = "select article_id,article_title,article_time,article_content,nav_id from article  where nav_id=?";
        List<Article> list=new ArrayList();
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,nav_id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Article article=new Article();
                article.setArticle_id(resultSet.getNString("article_id"));
                article.setArticle_title(resultSet.getString("article_title"));
                article.setArticle_time(resultSet.getString("article_time"));
                article.setArticle_content(resultSet.getString("article_content"));
                article.setNav_id(resultSet.getString("nav_id"));
                list.add(article);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
