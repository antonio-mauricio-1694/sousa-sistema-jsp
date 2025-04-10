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
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnectionBanco;


@WebFilter("/FilterAutenticacao")
public class FilterAutenticacao extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;
    
    private static  Connection connection;

	
    public FilterAutenticacao() {
        super();
        
    }

	//encerra todos os processos quando o servidor e parado
	public void destroy() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	//intercepta as requisiçoes e as respostas no sistema
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			String usuarioLogado = (String) session.getAttribute("usuario");
			String urlParaAutenticar = req.getServletPath(); //url que esta sendo acessada
			
			// validar para ser logado se nao retorna para o login
			
			if(usuarioLogado == null  && !urlParaAutenticar.contains("/principal/ServletLOgar")) {
				
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp?url="+urlParaAutenticar);
				request.setAttribute("msg", "Por Favor Realize o Login");
				redirecionar.forward(req, response);
				return; // para a executa
				
			}else {
				chain.doFilter(request, response);
			}
			
			connection.commit(); // salvar no banco
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			try {
				connection.rollback();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	} //

	//inicia os processesos ou recurso quando o servidor sobe 
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
		
	}

}
