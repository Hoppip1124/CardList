package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.CardDAO;
import dto.Card;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardListServlet
 */
public class CardListServlet extends HttpServlet {
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
		 * カード情報用のDAO
		 */
		CardDAO cardDao = new CardDAO();
		
		//"一覧表示"を押して表示するメッセージ
		String msg = "CARD LIST";
		
		//受け取る文字コードの設定
		request.setCharacterEncoding("utf-8");
		
		//入力値"btn"を取得
		String btn = request.getParameter("btn");
		
		
		//btn値による分岐処理
		if (btn.equals("登録")) {
			
			//リクエストパラメータから値の取得
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			int hp = Integer.parseInt(request.getParameter("hp"));
			String skill1 = request.getParameter("skill1");
			String skill2 = request.getParameter("skill2");
			
			//登録レコードの作成
			Card card = new Card(id, name, type, hp, skill1, skill2);
			
			//ID重複チェック->登録処理
			try {
				if (!cardDao.isExists(id)) {
					
					int cnt = cardDao.insert(card);
					
					//処理メッセージの設定
					msg = "CARD ID : " + id + "のカードを" + cnt + "件登録しました";
				
				} else {
					//エラーメッセージの設定
					msg = "そのIDはすでに存在します";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else if (btn.equals("更新")) {
			
			//リクエストパラメータから値の取得
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			int hp = Integer.parseInt(request.getParameter("hp"));
			String skill1 = request.getParameter("skill1");
			String skill2 = request.getParameter("skill2");
			
			//更新レコードの作成
			Card card = new Card(id, name, type, hp, skill1, skill2);
			
			//IDが存在するか判定
			try {
				if (cardDao.isExists(id)) {
					
					//更新処理
					int cnt = cardDao.update(card);
						
					//処理メッセージの設定
					msg = "CARD ID : " + id + "のカードを更新しました";
						
				} else {
					//エラーメッセージの設定
					msg = "IDが存在しません";
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		} else if (btn.equals("削除")) {
			
			//リクエストパラメータからの値の取得
			String id = request.getParameter("id");
			
			//IDが存在するか判定->削除処理
			try {
				if (cardDao.isExists(id)) {
				
					int cnt = cardDao.delete(id);
					
					//処理メッセージの設定
					msg = "CARD ID : " + id + "のカードを" + cnt + "件削除しました";
					
				} else {
					//エラーメッセージの設定
					msg = "IDが存在しません";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//一覧検索
		List<Card> cardList = null;
		
		try {
			cardList = cardDao.selectAll();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//リクエストスコープへの格納
		request.setAttribute("cardList", cardList);
		request.setAttribute("msg", msg);
		
		//転送
		RequestDispatcher dispatcher = request.getRequestDispatcher("CardList.jsp");
		dispatcher.forward(request, response);
		
	}

}
