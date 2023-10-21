package org.example.repository;

import org.example.entity.BoardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author 임승범
 */
@Repository
public interface BoardInfoRepository extends JpaRepository<BoardInfo, Long> {

}
