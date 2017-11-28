package br.com.mones.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserBean {
	private User user;
    public void setUsuario(User u) {
        this.user = u;
    }
    public User getUsuario() {
        return this.user;
    }
}
