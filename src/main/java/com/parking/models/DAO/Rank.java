package com.parking.models.DAO;

import com.parking.models.security.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "_rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rankId;
    private String rankName;

    @OneToMany(mappedBy = "rank", cascade = CascadeType.MERGE)
    private Set<User> users;

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
}
