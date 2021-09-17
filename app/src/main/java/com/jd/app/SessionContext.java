package com.jd.app;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class SessionContext {
    private static SessionContext instance;
    private HashMap sessionMap;
    private SessionContext(){
        sessionMap = new HashMap();
    }

    public static SessionContext getInstance(){
        if (instance == null) {
            instance = new SessionContext();
        }
        return  instance;
    }

    public  synchronized  void addSession(HttpSession session){
        if (session != null) {
            sessionMap.put(session.getId(),session);
        }
    }

    public synchronized void deleteSession(HttpSession session){
        if (session != null){
            sessionMap.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String sessionId){
        if (sessionId == null) {
            return null;
        }
        return  (HttpSession)sessionMap.get(sessionId);
    }
}
