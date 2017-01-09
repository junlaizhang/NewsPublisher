package com.action.bean;

import com.entity.Manager;
import com.entity.Nav;

import com.impDao.ManagerImpDao;

import java.util.List;

/**
 * Created by junlai on 2017/1/7.
 */
public class ActionBean {
    public String queryManagerAll() {
        ManagerImpDao managerImpDao = new ManagerImpDao();
        List<Manager> list = managerImpDao.queryManagerAll();
        String tableHtml = "";
        int i = 1;
        for (Manager manager : list) {
            tableHtml += "<tr><td><input type=\"radio\" name=\"rad\" autocomplete=\"off\" value=\"" + manager.getManager_id() + " \"/></td><td class=\"text-center\">" + (i++) + "</td><td class=\"text-center\">" + manager.getManager_id() + "</td><td class=\"text-center\">" + manager.getManager_name() + "</td></tr>";
        }
        return tableHtml;
    }

    public Manager queryManagerById(String manager_id) {
        ManagerImpDao managerImpDao = new ManagerImpDao();
        Manager manager = managerImpDao.queryManagerById(manager_id);
        return manager;
    }

    public String queryNavAll() {
        ManagerImpDao managerImpDao = new ManagerImpDao();
        List<Nav> list = managerImpDao.queryNavAll();
        String tableHtml = "";
        int i = 1;
        for (Nav nav : list) {
            tableHtml += "<tr><td><input type=\"radio\" name=\"rad\" autocomplete=\"off\" value=\"" + nav.getNav_id() + " \"/></td><td class=\"text-center\">" + (i++) + "</td><td class=\"text-center\">" + nav.getNav_name() + "</td><td class=\"text-center\">" + nav.getNav_weight() + "</td></tr>";
        }
        return tableHtml;
    }
    public Nav queryNavById(String nav_id) {
        ManagerImpDao managerImpDao = new ManagerImpDao();
        Nav nav = managerImpDao.queryNavById(nav_id);
        return nav;
    }
}
