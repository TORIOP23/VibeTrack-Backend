package com.vibetrack.aurora.repository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AcousticFeatureRepository {

    JdbcClient jdbcClient;

    public Map<String, Integer> getAllAcousticFeaturesById(List<String> songIds) {
        String sql = "SELECT song_id, acoustic_features FROM acoustic_features WHERE song_id IN (:songIds)";
        return jdbcClient.sql(sql)
                .param("songIds", songIds)
                .query((rs, rowNum) -> Map.of(rs.getString("song_id"), rs.getInt("acoustic_features")))
                .single();
    }
}
