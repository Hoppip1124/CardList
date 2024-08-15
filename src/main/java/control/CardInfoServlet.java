package control;

import java.io.IOException;
import java.sql.SQLException;

import dao.CardDAO;
import dto.Card;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardInfoServlet
 */
public class CardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * カード情報用DAO
		 */
		CardDAO cardDao = new CardDAO();
		
		//"ID SEARCH"を押して表示するメッセージ
		String msg = "CARD INFORMATION";
		
		//受け取る文字コードの設定
		request.setCharacterEncoding("utf-8");
		
		//リクエストパラメータから値の取得
		String id = request.getParameter("id");
		
		//結果格納用Card
		Card card = new Card();
		
		//IDが存在するか判定？検索処理：エラーメッセージの設定
		try {
			if (cardDao.isExists(id)) {
				card = cardDao.selectById(id);
			} else {
				//エラーメッセージの設定
				msg = "IDが存在しません";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//リクエストスコープへ格納
		request.setAttribute("card", card);
		request.setAttribute("msg", msg);
		
		//転送
		RequestDispatcher dispatcher = request.getRequestDispatcher("CardInfo.jsp");
		dispatcher.forward(request, response);
		
	}

}
