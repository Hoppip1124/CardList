# 概要
JavaとMySQLを使用して作成されたWebアプリケーションです。ユーザーは、カードのリストを作成し、追加、編集、削除することができます。

# 主な機能
・カードの一覧表示、追加、編集、削除、IDによるカード情報検索表示
・MySQLデータベースとの連携
・MVCアーキテクチャの実装

# 使用技術
・バックエンド: Java, JSP, サーブレット
・データベース: MySQL
・フロントエンド: HTML, CSS
・ツール: Eclipse, Apache Tomcat

# 開発経緯
Javaとデータベース（MySQL）の連携技術を学ぶために制作しました。はじめにJavaアプリケーションとデータベースの接続および操作、次にJavaサーブレットとJSPを使用したパラメータの受け渡しを学び、それらを組みわせて本アプリケーションを制作しました。

# 課題点
1.コードの構造および設計
　サーブレットやJSPのロジックが複雑になる場合、サービス層を導入してビジネスロジックを分離することを検討。

2.データベース連携
　SQLインジェクションの防止のため、プリペアドステートメントの導入（一部導入済み）。例外処理やトランザクション管理についても考慮。

3.セキュリティ
　ユーザー入力のバリデーション、セッション管理、XSS（クロスサイトスクリプティング）対策など、より高度なセキュリティ対策についても意識。

# 制作期間
・Java/データベース/サーブレット/JSP 学習期間　2週間
・本アプリケーション制作期間　1週間