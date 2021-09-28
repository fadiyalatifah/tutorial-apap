package apap.tutorial.cineplux.repository;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BioskopDB extends JpaRepository<BioskopModel, Long> {
    Optional<BioskopModel> findByNoBioskop(Long noBioskop);
    Optional<BioskopModel> findByNamaBioskop(String namaBioskop);
//    List<BioskopModel> findAllByNamaBioskopAsc;
}
