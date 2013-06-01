ListViewWithSqlite-Week4
========================

Simple sample dalam penggunaan SQLite di Android.

src/
- Halaman1.java, activity yang di launch pertama kali ketika app dibuka, berisi EditText dan Button
- Halaman2.java, activity yang di launch setelah tombol Button di Halaman1.java di tap, 
  berisi ListView untuk menampilkan data-data yang ada di SQLite
- SqliteHelper.java, helper class untuk Sqlite, extends SqliteOpenHelper. 
  Isinya variable nama database, table, field-field dalam table, dan method onCreate untuk eksekusi query Create table.
- ItemDataSource.java, helper untuk table items di Sqlite, isinya method untuk query ke table.
- Item.java, Plain Old Java Object (POJO) sebagai representasi satu table di Sqlite.

res/
- halaman1.xml, layout untuk activity Halaman1
- halaman2.xml, layout untuk activity Halaman2
- mytextview.xml, layout untuk row di ListView


After import project to Eclipse, don't forget to Project -> Clean.

Any improvement such as using progressbar while loading to database, etc are very welcome.

Sharing is caring :)
