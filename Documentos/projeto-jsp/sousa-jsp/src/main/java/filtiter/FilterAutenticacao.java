package filtiter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/FilterAutenticacao")
public class FilterAutenticacao extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

	
    public FilterAutenticacao() {
        super();
        
    }

	//encerra todos os processos quando o servidor e parado
	public void destroy() {
		
	}

	//intercepta as requisiçoes e as respostas no sistema
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath(); //url que esta sendo acessada
		
		// validar para ser logado se nao retorna para o login
		
		if(usuarioLogado == null || (usuarioLogado != null &&  usuarioLogado.isEmpty()) &&
				!urlParaAutenticar.contains("/principal/ServletLOgar")) {
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp?url="+urlParaAutenticar);
			request.setAttribute("msg", "Por Favor Realize o Login");
			redirecionar.forward(req, response);
			return; // para a executa
			
		}else {
			chain.doFilter(request, response);
		}
		
	}

	//inicia os processesos ou recurso quando o servidor sobe 
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
