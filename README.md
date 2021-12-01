# Tutorial APAP
## Authors
* **Fadiya Latifah** - *1906399442* - *C*

## Tutorial 7
### Pertanyaan
**1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?**


**2. Jelaskan fungsi dari async dan await!**
async
await

**3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini.** 


**4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.**


## Tutorial 7
### Pertanyaan
**1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan**
* Latihan 1 (Menghapus my cart) = 
![image](https://user-images.githubusercontent.com/81474184/143247247-c9032217-69ce-40a6-8e13-4025bdf9f502.png)
![image](https://user-images.githubusercontent.com/81474184/143247413-8b5d8038-b5c7-434a-ab8e-6eedb2fb4982.png)
Untuk menghapus my cart, saya membuat suatu function baru bernama handleDeleteFromCart. Utamanya fungsi yang dijalankan cukup mirip dengan handleAddItemToCart. Namun saya mengubah targetInd >= 0 karena kita hanya bisa menghapus jika cart  barang tersebut telah di-checkout. Lalu saya menggunakan method splice(targetInd, 1) untuk menghapus 1 box item yang telah diapus di targetInd. Lalu untuk newItem.inCart dan parameter update menjadi false karena kita ingin membuat item yang nantinya akan dihapus menjadi terdeteksi tidak ada di cart. Setelah membuat function, saya menambahkan action onclick this.handleDeleteItemFromCart jika icon hapus di-click.

* Latihan 2 (Mengubah balance) =
![image](https://user-images.githubusercontent.com/81474184/143247927-b2575d2e-290d-4dd9-bc05-63d2ea15141b.png)
![image](https://user-images.githubusercontent.com/81474184/143247247-c9032217-69ce-40a6-8e13-4025bdf9f502.png)
Untuk mengubah balance, saya mengubah fungsi ketika menampah atau menghapus item dari dan ke cart (handleAddItemToCart & handleDeleteItemFromCart). Pertama, kita harus mendapatkan state balance terakhir dengan memintahkan valuenya ke variabel itemBalance. Lalu setiap menambahkan barang ke cart, maka balance akan dikurangi dengan harga barang dengan mengubah state balance (this.setState({ balance: itemBalance - newItem.price })). Sedangkan setiap menghapus barang dari cart, maka balance akan ditambah dengan harga barang dengan mengubah state balance this.setState({ balance: itemBalance + newItem.price })

* Latihan 3 (cek sisa balance)=
![image](https://user-images.githubusercontent.com/81474184/143248124-bf1aeed7-0228-405f-bc1a-082df041c882.png)
Untuk menambahkan constrain tidak boleh menambahkan item ketika balance kurang, saya mengecek itemBalance di fungsi handleAddItemToCart. Jika harga barang baru yang mau di pindahkan ke cart itu kurang dari saldo yang dimiliki, maka program akan mengeluarkan alert bahwa saldo tidak mencukupi.


**2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?**
* State = Merupakan komponen yang bisa dimodifikasi secara asynchronous menggunakan fungsi setStates. Pada lab ini contohnya, di awal akan didefinisikan this.state untuk mengetahui apa saja atribut state pada constructor. State pada kasus ini adalah shopItems: listItems, cartItems: [], cartHidden: true, balance: 120. Kita bisa mengubah tampilan list item yang sudah dimasukkan ke keranjang menggunakan this.setState({ cartItems: newItems }) sehingga state cartItems yang tadinya list kosong, sekarang berubah menjadi berisi barang yang ditambahkan.

* Props = Merupakan komponen yang bersifat read-only, alias tidak dapat diubah. Props berbentuk parameter dari sebuah function, contohnya props dari item yang di-syntaxkan seperti export default function Item(props). Props digunakan untuk komunikasi data component dari parent ke child. Contohnya pada class home, props merupakan props dari supernya.

**3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.**
Menurut saya, penggunaan component seperti list dan item sangat berguna. Hal ini terjadi karena penggunaan komponen akan membuat code kita bisa digunakan berulang kali dengan memanggil tag-nya saja. Contohnya pada lab kali ini, di home terdapat pemanggilan List untuk menampilkan list item apa saja yang akan muncul di home. Dengan begitu setiap cards item pada file items.json bisa ditampilkan dan juga bisa mendapat handling yang sama untuk suatu action/event.

**4. Apa perbedaan class component dan functional component?**
* Class component = Mengacu kepada contoh di lab kali ini, didapatkan temuan bahwa class component memiliki state. hal ini terjadi karena syntax set dan this membuat state membutuhkan pengelompokan komponen dalam kelas-kelas tertentu. Komponen ini memiliki render yang mengembalikan HTML serta memiliki constructor.

* Functional component = Functional component normalnya hanya menerima props sebagai argumen dan mengembalikan elemen React. Komponen ini tidak memiliki method render karena fungsinya hanya sebatas menerima data lalu menampilkannya dalam beberapa bentuk. Karena sifatnya itu, komponen ini biasanya lebih banyak digunakan untuk UI component. 


**5. Dalam react, apakah perbedaan component dan element?**
* Component = Merupakan class atau function yang menerima input react (bisa dlm bentuk props) dan juga mengembalikan elemen tree React. Dengan komponen, code kita bisa digunakan berulang kali dengan memanggil tag-nya saja. Komponen bisa terdiri dari banyak elemen.

* Element = Merupakan representasi sebuah object dari DOM nodes yang menjelaskan apa yang muncul di layar. Elemen berisi plain old object, bukan elemen DOM yang asli. Element juga bisa mengandung element lain.

## Tutorial 6
### Pertanyaan
**1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?**
* Otentikasi : Merupakan proses memverifikasi dan mengidentifikasi siapa user (beserta detailnya). Contohnya seperti apakah pengguna merupakan user yang sesuai, mempunyai role, dan lain-lain. Otetikasi biasanya dilakukan saat user login lalu memasukkan nama, password, dan info lainnya. Tidak seperti otorisasi, otentikasi dapat dilihat dan biasanya sebagiannya dapat diubah oleh pengguna. Pada lab kali ini, otentikasi pertama didukung oleh pada form login beserta htmlnya. Pada halaman itu, kita mendapatkan username dan password user. Lalu  otorisasi utamanya terdapat pada fungsi WebSecurityConfig bernama configAuthentication. Disitu, data yang telah dimasukan user pada login akan dicek. Berikut syntaxnya:

    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

* Otorisasi: Merupakan proses menentukan atau memverifikasi fitur atau resource apa saja yang dapat diakses pengguna dalam suatu sistem, atau dalam kata lain proses menentukan apakah user memiliki akses ke suatu resource. Otorisasi selalu dilakukan setelah autenthication, dan biasanya tidak dapat diubah karena telah diatur oleh pembuat sistem. Pada lab kali ini, autorisasi terdapat pada command .authorizeRequests() di method configure yang berada di file WebSecurityConfig

**2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.**

> BCryptPasswordEncoder merupakan salah satu password encoder yang digunakan pada modul security di spring boot. BCryptPasswordEncoder bertujuan agar bisa dilakukan password encoding beserta password validate agar password aman dan tidak gampang diteras atau dilihat pihak selain user pemilik password tersebut. 

> Cara kerjanya adalah menggunakan algoritma one-way encryption bernama BCrypt dengan stong hashing function. Setelah password dienkripsi dengan BCryptPasswordEncoder, password disimpan dalam database. Jika lupa password, maka password harus kembali di dienkripsi, dibuat, dan disimpan ulang. Jika disimpan 2 kali, maka setiap call akan menghasilkan hasil enkripsi yang berbeda-beda. Password yang telah di hashing tidak bisa di decrypt kembali.

**3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?**
> Penyimpanan password lebih baik menggunakan hashing dibandingkan dengan encryption. Alasannya adalah karena hashing adalah one-way function, dimana jika user telah menghashing password, maka siapapun tidak mungkin bisa men-decrypt password untuk mendapatkan nilai awalnya lagi. Alasan lain dari segi keamanannya adalah, bahkan jika ada hacker yang mendapatkan kata sandi hash, hacker tersebut tidak dapat memasukkan password lalu login sebagai korban. Sebaliknya, sangat tidak disarankan menggunakan enkripsi karena enkripsi merupakan two-way function, jadi bisa saja password yang telah dienkripsi kembali dilakukan dekripsi untuk mendapat plain text value (nilai aslinya).

**4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!**
> Universally unique identifier atau yang biasa disingkat UUID adalah standart identikasi informasi di sistem komputer yang terdiri dari 128-bit angka. UUID terdiri dari 16 oktet yang direpresentasikan sebagai 32 basis-16 karakter. UUID biasanya digunakan dalam mengidentifikasi informasi yang perlu dibuat unik dalam suatu sistem atau jaringan. UUID juga bisa digunaan sebagai associative keys pada database, serta bisa membuat mengidentifikasi perangkat keras fisik dalam suatu organisasi.

**5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java**
> Pada lab ini, UserDetailsServiceImpl.java berguna untuk membangun otentikasi dan otorisasi dari user. File UserDetailsServiceImpl.java sangat berguna dalam pengaplikasian security pada spring karena terdapat class yang meng-extend  modul UserServiceDetail dari spring security. Pada class ini setelah detail user dikirimkan melalui otentikasi, data yang user masukan akan membuat sistem mengecek apakah user ini bisa masuk ke sistem, serta resource atau action apa saja yang bisa dilihat dan dilakukan. Kalau userserviceimpl itu lebih berperan kepada fungsi apa saja semua di user secara general tanpa melihat role atau apakah user tersebut terotorisasi/terotentikasi seperti bisa menambah user, enkripsi password user, dan mendapat list user. 


## Tutorial 5
### Pertanyaan
1. Apa itu Postman? Apa kegunaannya?
> Postman adalah aplikasi yang berperan sebagai REST Client, yaitu tools untuk melakukan uji coba REST API. Postman berguna dalam proses development/testing API karena mampu menguji API yang telah dibuat developer, atau biasa disebut GUI API Caller. Contoh fitur yang berguna adalah fitur mock server, yaitu fitur yang berguna untuk menguji API yang belum di deploy namun sudah bisa diakses dari internet dengan postman ini. Postman juga sangat berguna bagi developer/QA untuk mengumpulkan API yang dapat dibuat menjadi sebuah dokumentasi full dari suatu proyek.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
> @JsonIgnoreProperties: Perintah ini berfungsi untuk menandai daftar properties yang akan diabaikan pada class level. Fungsi ini dapat digunakan ketika kita ingin mengabagikan pemprosesan JSON saat desentralisasi agar hasil API REST call nya hanya informasi yang penting (lebih bersih hasil REST API nya).
> @JsonProperty: Perintah ini berfungsi untuk menspesifikkan method non-standard getter-setter untuk variable selain serialisasi dan deserialisasi biasa. @JsonProperty berguna untuk menandai getter setter untuk digunakan dengan json property. Nama  properti akan dipetakan (mapping) sengan keys dari JSON selama proses serialisasi dan deserialisasi. 

3. Apa kegunaan atribut WebClient?
> Webclient yang ada pada BioskopRestServiceImpl berguna untuk menerima/mengirim dari dari URI yang direquest(Remote REST service). Webclient juga merupakan antarmuka yang mewakili entry point dalam melakukan request ke web di spring.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
> ResponseEntity : merupakan objek yang termasuk ke extension dari HttpEntity yang merepresentasikan segala komponen pada HTTP response. HTTP response meliputi body, status, dan headers. Kegunaan ResponseEntity adalah agar pengguna bisa memodifikasi respons dengan status code atau header yang opsional.  
> BindingResult: merupakan objek atau general interface  yang menyimpan hasil validasi dan binding, juga berisi kesalahan yang mungkin terjadi pada program Spring. Objek ini harus ada setelah objek model tervalidasi. Jika gagal, maka spring akan melempar exception. 


## Tutorial 4
### What I have learned today
Pada hari ini, saya belajar lebih lanjut tentang thymeleaf & requestmapping 
### Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!
> Menurut pengetahuan dan beberapa sumber yang saya baca,  perbedaan keduanya adalah, th:include akan menyertakan isi content fragment ke dalam host tag-nya. Content akan disisipkan ke body-nya host tag, tapi fragment/ host tag fragment tidak akan disisipkan. Sedangkan pada th:replace , fragment justru yang akan menggantikan tag hostnya. Atau dalam kata lain pada th:replace, tag host akan dihapus dan fragmen beserta host tagnya akan menggantikan tag host tersebut. 

2. Jelaskan apa fungsi dari th:object!
> th:object berfungsi untuk menspesifikasikan object yang akan diikat oleh formulir yang dikirimkan. Pada lab ini, th:object digunakan saat pengiriman form add & update bioskop ataupun penjaga. Contohnya dengan mengikat objek bioskop "th:object="${bioskop}" pada formulir add bioskop, maka saat formulir di post, value dari pengisian formulir di html akan di-pass ke controller.


3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
> th:object yang menggunakan asterisk(*) akan mengevaluasi expression hanya pada objek-objek yang dipilih, bukan keseluruhan konteks. Sedangkan th:object yang menggunakan dollarsign($) akan mengevaluasi expression pada seluruh objek yang diikat. Contohnya penggunaan th:object $ pada konteks bioskop adalah "th:object="${bioskop}". Sedangkan asterisk bisa digunakan pada salah satu atribut di bioskop, contohnya "th:object="*{noBioskop}".


### What I did not understand

## Tutorial 3
### What I have learned today
Pada hari ini, saya kembali mempelajari service, model, dan controller. Lalu saya belajar tentang cara menggunakan  Java Persistence API (JPA) untuk mengintegrasikan database server. Selain itu juga belajar package-package yang ada di lombok.
### Pertanyaan
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table) 

* @AllArgsConstructor = Merupakan salah satu interface bawaan package lombok yang berfungsi untuk menghasilkan/mengeluarkan constructor dengan 1 argumen untuk setiap field(bidang) di dalam class. Constructor yang dihasilkan secara default akan bertipe public dan tidak akan ke static field. Contoh fieldnya adalah @NonNull.
* @NoArgsConstructor = Merupakan salah satu interface bawaan package lombok yang berfungsi untuk men-generate constructor dengan 0 parameter (no parameter constructor). interface ini akan menghasilkan pesan error jika constructor tidak bisa dibuat akibat adanya final fields.
* @Setter = Merupakan salah satu syntax di lombok yang berguna agar lombok bisa menghasilkan method setter public secara otomatis untuk semua field di sebuah class. Jadi tidak perlu memasang setter secara manual seperti java pada umumnya.
* @Getter = Merupakan salah satu syntax di lombok yang berguna agar lombok bisa menghasilkan method getter public secara otomatis untuk semua field di sebuah class. Jadi tidak perlu memasang getter secara manual seperti java pada umumnya.
* @Entity = @Entity berguna untuk membuat suatu string yang dimasukkan setelahnya menjadi nama entity. Atau dalam kata lain merupakan class pada model untuk menujukkan bahwa ini adalah entitas/bisa juga nama tabel default. 
* @Table =  @Entity berguna untuk membuat suatu string yang dimasukkan setelahnya menjadi nama tabel di dalam database. @Table dapat digunakan untuk mengganti nama tabel jika ingin mengubah nama yang ada di default @Entity.

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut? 
Method findByNoBioskop adalah method yang berfungsi untuk mencari data bioskop di database berdasarkan nomor bioskop yang didapatkan dari parameter fungsi ini. Pada method ini terdapat "findBy" yang merupkaan bawaah dari JPA repository yang sudah diimport. Dengan penggunaan findBy, maka pengambilan data bioskop bisa dilakukan secara langsung, tanpa harus mengakses ke tabel menggunakan query.  

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn 

@JoinTable pada JDA biasanya bisa digunakan untuk mendapat database yang lebih ternormalisasi dan tidak banyak redundansi data akibat penggabungan banyak entitas. @JoinTable merupakan default typenya. @JoinTable bisa digunakan untuk mengatur hubungan antara antitas dengan tabel lain sehingga ketika data diakses, tabel harus di gabung dulu untuk mendapat sebuah hubungan.

Sedangkan @JoinColumn biasa digunakan untuk menandai bahwa sebuah kolom itu merupakan kolom gabungan dari beberapa entitas/elemen. Biasa digunakan ketika entity punya hubungan langsung. @JoinColumn digunakan untuk meningkatkan performance karena bisa diguanakan tanpa harus menggabungkan tabel tambahan(langsung akses saja kolomnya).

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
* name = untuk menamai kolom baru yang merupakan gabungan lebih dari satu elemen/entitas, atau dalam kata lain sebagai nama kolom foreign key
* referencedColumnName = berisi nama kolom yang dijadikan referensi/rujukan oleh kolom name(foreign key)
* nullable: menandai apakah kolom foreign key boleh bernilai null atau tidak. 
* Perbedaan nullable dengan @NotNull = Kalau nullable merupakan element bertipe boolean untuk menandakan apakah kolom foreign key boleh bernilai null atau tidak. Sedangkan @NotNull itu menandakan bahwa nilainya tidak boleh null. jika nilainya kosong masih dilegalkan.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
* FetchType.LAZY = Merupakan salah satu strategi mengambil data dari database, dimana database diambil dengan lazy( inisialisasi objek ditunda selama mungkin) saat pertama kali diakses. Jadi data akan diinisialisasi dan dimuat ke dalam memori ketika ada panggilan eksplisit saja.
* CascadeType.ALL = Merupakan salah satu cara menyimpan entitas yang dipetakan setiap entitas owner disimpan. CascadeType.ALL digunakan bila kita ingin membuat rules bahwa semua action/perubahan yang terjadi antara owner dengan entitas lain, haruslah di cascade.
* FetchType.EAGER = Merupakan salah satu strategi mengambil data dari database, yang merupakan persyaratan pada runtime provider bahwa data harus diambil dengan eager(inisiasi data terjadi di tempat). Jadi ketika load suatu data, maka akan memanggil data lain yang terasosiasi juga lalu menyimpannya di memori

### What I did not understand


## Tutorial 2
### What I have learned today
1. Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?

Pada saat saya menambahkan bioskop melalui link tersebut, terjadi error 500 dengan spesific error "Error resolving template[add-bioskop]". Hal ini terjadi karena pada saat itu, saya belum membuat template/halaman html add-bioskop. Sedangkan di controller saya sudah menginisiasi return "add-bioskop". Agar tidak error, kita harus membuat page htmlnya terlebih dahulu.

2. Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat!

Setelah saya membaca beberapa referensi dari internet dan digabungkan dengan pendapat saya, menurut saya @autowired merupakan implementasi dari konsep Dependency injection. Cara kerja autowired dalam service dan controller adalah, autowired membuat spring mungkin untuk menyelesaikan & menginjeksikan bean bioskopservice ke pihak yang mengimplemennya(bioskopinmemoryservice). Sehingga pada controller, otomatis memiliki semua objek dari yang mengimplementnya. jadi controller bisa langsung mendapat service tanpa harus mengimplementasi variabel/elemen/constructor dari bioskopservice.

3. Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Pada saat saya menambahkan bioskop melalui link tersebut, terjadi error 400 dengan spesifik error "required request parameter 'jumlah studio' for method parameter type is not present". Hal ini terjadi karena web di atas tidak lengkap, tidak memiliki parameter jumlahstudio. Sehingga agar tidak error, link nya harus ditambahkan jumlah studio setelah nomor teleponnya.


4. Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?

Untuk melihatnya, asumsikan saya telah membuat bioskop baru bernama Bioskop Maung dengan id 2 melalui akses link http://localhost:8080/bioskop/add?idBioskop=2&namaBioskop=Bioskop%20Maung&alamat=Jalan%20Fasilkom&noTelepon=0817676&jumlahStudio=8. Maka setelah itu, kita bisa melihatnya melalui link http://localhost:8080/bioskop/view?idBioskop=2.


5. Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

Setelah memiliki 2 bioskop sebelumnya, saya menambahkan lagi bioskop ber-id 3 melalui link http://localhost:8080/bioskop/add?idBioskop=3&namaBioskop=Bioskop%20Fadiya&alamat=Jalan%20Taman&noTelepon=0211906399442&jumlahStudio=5. Lalu setelah mengakses halaman viewall, maka akan terlihat semua biskop saya (saat itu ada 3 bioskop). Setelah menambahkan dan membuka page viewall, setiap bioskopnya akan terlihat valuenya/parameternya. Mulai dari id, nama bioskop, alamat, nomor telepon, dan jumlah studio. Tampilan ini akan sesuai dengan kode html yang ditulis di html viewall-bioskop.html. Berikut screenshootnya:
![screenshoot page viewAll](viewall.png)


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
