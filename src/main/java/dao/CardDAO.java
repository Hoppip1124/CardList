package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Card;

public class CardDAO {
	
	/**
	 * 指定IDのレコードが存在するか判定
	 * @param cardId
	 * @return
	 * @throws SQLException
	 */
	public boolean isExists(String cardId) throws SQLException {
		
		//SQL作成
		String sql = "SELECT COUNT(*) FROM m_card WHERE card_id = ?";
		
		//JDBCドライバ
		try {
			Class.forName("com.mysql.jdbc.Driver");
					
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		//try with resource
		try (Connection db = MyConnection.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			
			//プレースホルダへの値設定
			pstmt.setString(1, cardId);
			
			//データベースに指定IDのレコードがあるか判定
			try (ResultSet res = pstmt.executeQuery()) {
				if (res.next()) {
					return res.getInt(1) > 0;
				}
				
			}
		}
		
		return false;
		
	}
	
	/**
	 * カード一覧表示処理
	 * @return
	 * @throws SQLException
	 */
	public List<Card> selectAll() throws SQLException {
		
		//結果格納用
		List<Card> cardList = new ArrayList<Card>();
		
		//SQL文
		String sql = "SELECT * FROM m_card";
		
		//JDBCドライバ
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try (Connection con = MyConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {
			
			//データベースから値の取得
			while (res.next()) {
				String cardId = res.getString("card_id");
				String cardName = res.getString("card_name");
				String cardType = res.getString("card_type");
				int cardHp = res.getInt("card_hp");
				String skill1 = res.getString("skill_1");
				String skill2 = res.getString("skill_2");
				
				//1件分のオブジェクト作成
				Card card = new Card(cardId, cardName, cardType, cardHp, skill1, skill2);
				
				//リスト格納
				cardList.add(card);
			}
		}
		
		//データベースから作成したカードリストを返す
		return cardList;
	}
	
	/**
	 * カード情報登録処理
	 * @param card
	 * @return
	 * @throws SQLException
	 */
	public int insert(Card card) throws SQLException {
		
		//戻り値の宣言
		int cnt;
		
		//SQLの作成
		String sql = "INSERT INTO m_card "
				+ "(card_id, card_name, card_type, card_hp, skill_1, skill_2) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		//JDBCドライバー
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		//try with resource
		try (Connection db = MyConnection.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			
			//プレースホルダに値を設定
			pstmt.setString(1, card.getCardId());
			pstmt.setString(2, card.getCardName());
			pstmt.setString(3, card.getCardType());
			pstmt.setInt(4, card.getCardHp());
			pstmt.setString(5, card.getSkill1());
			pstmt.setString(6, card.getSkill2());
			
			//追加処理の実行
			cnt = pstmt.executeUpdate();
		}
		
		return cnt;
		
	}
	
	/**
	 * カード情報更新処理
	 * @param card
	 * @return
	 * @throws SQLException
	 */
	public int update(Card card) throws SQLException {
		
		//戻り値の宣言
		int cnt;
		
		//SQLの作成
		String sql = "UPDATE m_card "
				+ "SET card_name = ?, card_type = ?, card_hp = ?, skill_1 = ?, skill_2 = ? "
				+ "WHERE card_id = ?";
		
		//JDBCドライバー
		try {
			Class.forName("com.mysql.jdbc.Driver");		
		} catch (ClassNotFoundException e) {
		      e.printStackTrace();
		}
		
		//try with resource 
		try (Connection db = MyConnection.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			
			//プレースホルダに値を設定
			pstmt.setString(6, card.getCardId());
			pstmt.setString(1, card.getCardName());
			pstmt.setString(2, card.getCardType());
			pstmt.setInt(3, card.getCardHp());
			pstmt.setString(4, card.getSkill1());
			pstmt.setString(5, card.getSkill2());
			
			//レコード更新処理
			cnt = pstmt.executeUpdate();
		}
		
		return cnt;
	}
	
	/**
	 * カード情報削除処理
	 * @param cardId
	 * @return
	 * @throws SQLException
	 */
	public int delete(String cardId) throws SQLException {
		
		//戻り値の宣言
		int cnt;
		
		//SQL作成
		String sql = "DELETE FROM m_card WHERE card_id = ?";
		
		//JDBCドライバー
		try {
			Class.forName("com.mysql.jdbc.Driver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//try with resource
		try (Connection db = MyConnection.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			
			//プレースホルダへ値の設定
			pstmt.setString(1, cardId);
			
			//レコード更新（削除）処理
			cnt = pstmt.executeUpdate();
		}
		
		return cnt;
		
	}
	
	/**
	 * カード検索処理
	 * @param cardId
	 * @return
	 * @throws SQLException
	 */
	public Card selectById(String cardId) throws SQLException {
		
		//戻り値の初期化
		Card card = null;
		
		//SQL作成
		String sql = "SELECT * FROM m_card WHERE card_id = ?";
		
		//JDBCドライバー
		try {
			Class.forName("com.mysql.jdbc.Driver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//try with resource
		try (Connection db = MyConnection.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			
			//プレースホルダに値を設定
			pstmt.setString(1, cardId);
			
			//データベースからレコード取得
			try (ResultSet res = pstmt.executeQuery()) {
				
				if (res.next()) {
					String cardName = res.getString("card_name");
					String cardType = res.getString("card_type");
					int cardHp = res.getInt("card_hp");
					String skill1 = res.getString("skill_1");
					String skill2 = res.getString("skill_2");
					
					card = new Card(cardId, cardName, cardType, cardHp, skill1, skill2);
				}
			}
		}
		
		return card;
		
	}
}
