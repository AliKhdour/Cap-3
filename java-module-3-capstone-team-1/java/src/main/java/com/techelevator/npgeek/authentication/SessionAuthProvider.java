package com.techelevator.npgeek.authentication;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/************************************************************************************
 * Some background information:
 * 
 * A Java Bean is a POJO. (i.e. A Java class that follows the standard for beans)
 * 
 * A Spring bean is an object that is instantiated, assembled, and otherwise 
 * managed by a Spring IoC container.
 * 
 * A Spring IoC Container is used to managing the complete life cycle 
 * of a Spring bean from creation to its destruction. 
 * 
 * It uses Dependency Injection (DI) to manage components and 
 * Spring bean objects.
 * 
 * Configuration metadata which represent Java code, annotations 
 * or XML along with Java POJO classes are used by a Spring IoC Container
 * 
 ************************************************************************************/
/************************************************************************************
 * A bean can be session scoped allowing sharing of the bean and it's information
 * (i.e. instantiated once per session and reused 
 *       rather than instantiated when called and discarded)
 *       
 * The @Scope(value="session".....) annotation is used to give a bean session scope
 ************************************************************************************/

import com.techelevator.npgeek.model.User;
import com.techelevator.npgeek.model.UserDao;

/**
 * SessionAuthProvider
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionAuthProvider implements AuthProvider {

    public static final String USER_KEY = "appCurrentUser";

    private HttpSession session;
    private UserDao dao;

    @Autowired
    public SessionAuthProvider(HttpSession session, UserDao dao) {
        this.session = session;
        this.dao = dao;
    }

    @Override
    public boolean isLoggedIn() {
        return session.getAttribute(USER_KEY) != null;
    }

    @Override
    public User getCurrentUser() {
        return (User) session.getAttribute(USER_KEY);
    }

    @Override
    public boolean signIn(String username, String password) {
        User authenticatedUser = new User();
        authenticatedUser.setPassword(password);
        authenticatedUser.setUsername(username);
        session.setAttribute(USER_KEY, authenticatedUser);
		return true;
    }

    @Override
    public void logOff() {
        session.removeAttribute(USER_KEY);
        session.invalidate();
    }

    @Override
    public boolean changePassword(String existingPassword, String newPassword) {
        User userFromSession = (User) session.getAttribute(USER_KEY);
        if (userFromSession == null) {
            return false;
        }
        User userFromDb = dao.getValidUserWithPassword(userFromSession.getUsername(), existingPassword);
        if (userFromDb != null && userFromDb.getId() == userFromDb.getId()) {
            dao.changePassword(userFromSession, newPassword);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void register(String username, String password, String role) {
        dao.saveUser(username, password, role);
    }

    @Override
    public boolean userHasRole(String[] roles) {
        User currentUser = getCurrentUser();
        if (currentUser != null && roles != null) {
            return Arrays.asList(roles).contains(currentUser.getRole());
        } else {
            return false;
        }
    }
}