package com.teamid.utils;

import com.teamid.entity.exception.UnauthorizedException;
import javax.servlet.http.HttpSession;

/**
 * Created by 伟宸 on 2017/6/4.
 */
public class LoginUtils {

    public static long getLoginUserId(HttpSession session) {
        if (session.getAttribute("userId") == null)
            throw new UnauthorizedException("Login first");
        return (long)session.getAttribute("userId");
    }


}
