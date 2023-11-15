package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.UniversidadeDao;

@WebServlet(name = "ControleCursos", urlPatterns = {"/ControleCursos"})
public class ControleCursos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem;
        
        //Recebe a flag que vem do formulário
        flag = request.getParameter("flag");
        
        if(flag.equals("cadastro")){//cadcur.html
            String c, n, d;
            c = request.getParameter("codigo");
            n = request.getParameter("nome");
            d = request.getParameter("duracao");
            //Fazer cadastro
            Curso curso = new Curso();
            
            curso.setCodigo(c);
            curso.setDuracao(d);
            curso.setNome(n);
            
            //Chamar o método salvar curso            
            int resultado = new UniversidadeDao().salvarCurso(curso);
             if(resultado == 1){ //Salvou 
                 mensagem = "Curso " + n + " cadastrado com sucesso";
             } else {//Não salvou (deu erro)
                 mensagem = "Erro ao tentar salvar o curso";
             }           
            //Empacotar a mensagem para a View ("var da página .jsp", var dessa página)
            request.setAttribute("mensagem", mensagem);
            //Especificar para onde vai a mensagem
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            //Envia a mensagem para o mensagens.jsp
            disp.forward(request, response);
        } else if (flag.equals("excluir")){//excur.html
            String c;
            c = request.getParameter("codigo");
             
        }else if(flag.equals("alterar")){//altcur.html
            String c;
            c = request.getParameter("codigo");
            
        } else if (flag.equals("listar")){
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
