package jlm.service;

import jlm.entity.AccessToken;
import jlm.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author
 */
public interface UserService extends UserDetailsService
{
    User findUserByAccessToken(String accessToken);

    AccessToken createAccessToken(User user);
}
