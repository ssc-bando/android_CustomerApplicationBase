# 構造

* Activityは2つ。
   * ログイン処理系と、ログイン後の各種表示系。
   * それぞれにnavigationを持つ
* menuの自作が面倒(分かってない)だったのでmenuありのプロジェクトをベースに、
* ログイン系の遷移をするActivityを挿入した


# Navigationのメモ

* あくまで「とあるActivity内でのFragmentの遷移」を定義するものの様だ
* つまり「Navigationで同一アプリ内の別Activityに飛ぶ」のはあまり良く無さそう
   * DeepLinkとか駆使すればいいかもしれないが素直にstartActivity()した方が無難かも


# Navigation Drawerのメモ

* Drawerの呼び出しボタンが「三」な表示なるためには「トップレベルのディスティネーション」と認識させないといけない
   * ⇒ `AppBarConfiguration.Builder()`で指定する

* menuとして設定するエントリのidとfragmentのidは合わせないといけない
   * じゃないとタップで遷移してくれない
   * もし別のIDにするならNavigationUIあたりの処理を実装(か、add())することになるのでは


# その他

* ログイン処理周りとメイン処理系とを区切りたかったのでActivity自体を分けてみたが、Navigation stackをうまく調整すれば単一Activityでやり切れるかもしれない
   * https://qiita.com/oboenikui/items/81c099acf5c0cf5215ec
   * ただし**Navigation Drawerが常に表示される**事になるかもしれない
   * visible程度で調整できるとしたら楽だとは思うが・・・？


# 今後に向けて(?

* ログイン周りの状態管理はViewModelでやるのがよさそう
   * https://developer.android.com/topic/libraries/architecture/livedata?hl=ja
   * https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ja
