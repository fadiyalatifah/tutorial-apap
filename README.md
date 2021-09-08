# Tutorial APAP
## Authors
* **Fadiya Latifah** - *1906399442* - *C*
## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
    Issue tracker atau nama lainnya Issues adalah salah satu fitur tracking pada github yang terhubung ke github repository. Issues tracker memungkinkan kita untuk melacak pekerjaan/project yang sedang kita kembangkan. Issues bisa dikategorisasikan dengan labels dan milestones. Dengan menggunakan issue tracker, kita dapat melacak progres, enchancements, ataupun melakukan tracking bug dari project kita/tim kita. Issue tracker dapat mencegah error yang bisa saja terjadi ketika kita melakukan suatu project terdiri dari beberapa developer karena issue tracker berfokus pada kolaborasi. Kita bisa mengunggah progress kita untuk disebar, didiskusikan, atau dikomen oleh anggota tim yang lain sehingga memudahkan komunikasi dengan fitur-fitur yang ada di Issue. 

2. Apa perbedaan dari git merge dan git merge --squash?
    Git merge merupakan command git yang berguna untuk menggabungkan commit yang telah dipush sebelumnya ke repository github, namun dengan mempertahankan semua commit pada features branch yang telah ada sebelumnya, serta menyisipkannya dengan commit di master branch. Jadi setiap commit sebelumnya akan tetap ada dan digabungkan ke dalam sebuah commit di master branch untuk lines yang berubah.

    Sedangkan Git merge ---squash adalah opsi penggabungan di git yang akan menghasilkan commit gabungan dengan hanya satu parent. Yang membedakan dari git merge adalah pada git merge squash ini history dari banyak commit features branch sebelumnya akan hilang, lalu setelah berubahan itu diremas, akan dipindahkan kedalam suatu commit yang baru di master branch. 

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
    Dalam pengembangkan aplikasi, version control system akan membantu developer dalam efisiensi hingga memudahkan kolaborasi/pengembangan. Pertama, Version control system memiliki keunggulan yaitu membantu melacak perubahan code yang ada. Developer bisa melihat apa saja yang berubah di setiap versi file sehingga bisa cepat melacak letak error jika terdapat error. Kita juga bisa mengembalikan suatu versi aplikasi jika tidak sengaja menghapus suatu file/code. Kita bisa kembali ke versi yang lebih lama jika di versi terbaru program kita ada error. Lalu version control system juga memiliki keunggulan yaitu memudahkan kolaborasi karena membuat kita bisa mengintegrasikan pekerjaan lebih dari satu developer tanpa mempengaruhi alur kerja satu sama lain. Kita juga bisa melacak jika ada conflict dalam proses kolaborasi dalam pengembangan aplikasi.


### Spring
4. Apa itu library & dependency?
    Library adalah bagian dari sebuah software yang dapat digunakan di program atau project lainnya. Library memiliki jenis yaitu library internal dan library eksternal seperti 3rd party. Library bersifat non-executable tapi membutuhkan consumer. Library berisi sekumpulan class dengan fungsi yang mirip, lalu dikelompokkan bersama sehingga mudah digunakan dalam project lain. Sedangkan dependency adalah hubungan atau relasi antara 2 hal, contohnya seperti antar code atau antar code yang menggunakan beberapa library. 


5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
    Maven adalah adalah salah satu landasan dalam pengembangan Java, serta merupakan build management tool yang paling banyak digunakan untuk Java (Java build tools). Maven menggunakan konsep Object model yang berbasis XML File yang memungkinkan developer untuk memahami garis besar proyek Java yang akan dikembangkan dengan cepat. 
    
    Kita menggunakan maven karena memiliki banyak keunggulan jika kita ingin mengembangkan produk/aplikasi dengan Java. Maven dapat membuat struktur project sendiri sehingga project itu dapat dibuka dengan berbagai IDE. Lalu dependency bisa diatur dengan mudah karena biasanya development java membutuhkan banyak file jar diluar default file jar di JDK. Hanya tinggal definisikan saja di File POM.xml dependency-nya, maka file-file jar tersebut akan otomatis terdownload ke Repository. lalu maven juga mendukung pemeliharaan proyek jangka panjang dan memiliki pilihan plugins yang bervariasi.

    Terdapat beberapa alternatif untuk maven, diantaranya Gradle, Jira, Cmake, Apache Ant, dan Jenkins.


6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
    Selain untuk pengembangan web, Spring freamework juga bisa membantu pembuatan/pengembangan aplikasi enterprise, aplikasi yang terkait dengan big data, aplikasi processing, transaction, data access, hingga security.


7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
    @PathVariable adalah untuk mengekstrak data atau beberapa placeholder langsung dari URI dan mengambil nilai dari URI itu sendiri, sedangkan @RequestParam digunakan untuk mengekstrak query parameters.

    @PathVariable sebaiknya digunakan untuk RESTful web services, sedangkan @RequestParam lebih cocok untuk digunakan pada traditional website.


### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Flow serta keterkaitan antara file-file yang otomatis terbentuk saat membuat project springboot
