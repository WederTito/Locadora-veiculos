package br.unitins.locadora.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unitins.locadora.model.Usuario;

//@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/pages/*"})
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// deixando o fluxo seguir
		// Para desabilitar o filtro descomente as duas proximas linhas e comente o restante
//		chain.doFilter(request, response);
//		return;
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String endereco = servletRequest.getRequestURI();
		System.out.println(endereco);
		
		// retorna uma sessao corrente (false - nao cria uma sessao)
		HttpSession session = servletRequest.getSession(false);
		
		Usuario usuario = null;
		
		if (session != null)
			usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		if (usuario == null) {
			((HttpServletResponse) response).sendRedirect("/Locadora/login.xhtml");
		} else {
			
			if (usuario.getFuncao().getPaginasComPermissao().contains(endereco)) {
				chain.doFilter(request, response);
				return;
			} else 
				((HttpServletResponse) response).sendRedirect("/locadora/sempermissao.xhtml");
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Security inicializado ...");
		
		Filter.super.init(filterConfig);
	}

}