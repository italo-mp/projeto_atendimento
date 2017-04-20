package br.indra.atendimento.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.indra.atendimento.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	@Modifying
	@Query("UPDATE Atendimento atd SET atd.statusAtendimento = :status, atd.dataHora = :dataHora  where atd.id = :id")
	void finalizarAtendimento(@Param(value = "status") Character status, @Param(value = "dataHora") Date dataHora,
			@Param(value = "id") Long id);

	@Modifying
	@Query("UPDATE Atendimento atd SET atd.statusAtendimento = :status  where atd.id = :id")
	void atenderCliente(@Param(value = "status") Character status, @Param(value = "id") Long id);

	@Query("SELECT atd FROM Atendimento atd where atd.statusAtendimento ='P' ")
	List<Atendimento> buscarAtendimentosPendentes();

	@Query("SELECT atd FROM Atendimento atd INNER JOIN atd.pessoa as p WHERE (p.nome like:nomeBusca) or (atd.senha = :nomeBusca)")
	List<Atendimento> buscarNomeESenha(@Param(value = "nomeBusca") String nome);

}
