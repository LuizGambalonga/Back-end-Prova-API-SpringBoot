package com.Projeto.Betha.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Projeto.Betha.Model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
}
