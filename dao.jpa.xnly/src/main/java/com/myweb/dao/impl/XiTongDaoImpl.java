package com.myweb.dao.impl;

import com.myweb.dao.XiTongDao;
import com.myweb.dao.jpa.hibernate.JiashuRepository;
import com.myweb.dao.jpa.hibernate.LaorenRepository;
import com.myweb.dao.jpa.hibernate.UserRepository;
import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xiTongDao")
public class XiTongDaoImpl implements XiTongDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LaorenRepository laorenRepository;

    @Autowired
    private JiashuRepository jiashuRepository;

    @Override
    public List<User> findUsersByUsernameNotSuper() {
        return userRepository.findByUsernameNot("super");
    }

    public List<User> findUsersByUsername(String username) {
        return userRepository.findByUsernameAndUsernameNot(username, "super");
    }

    @Override
    public List<User> findUsersByUsernameAndIdNot(String username, int id) {
        return userRepository.findByUsernameAndIdNot(username,id);
    }

    @Override
    public List<Laoren> findLaorens(Laoren laoren) {
        return laorenRepository.findAll(Example.of(laoren));
    }

    @Override
    public List<Jiashu> findJiashus(Jiashu jiashu) {
        return jiashuRepository.findAll();
    }

    @Override
    public int saveJiashu(Jiashu jiashu) {
        Jiashu js = jiashuRepository.saveAndFlush(jiashu);
        if (js != null) {
            return 1;
        }
        return 0;
    }


    @Override

    public int updateJiashuById(Jiashu jiashu) {
        Jiashu js = jiashuRepository.getOne(jiashu.getId());
        if (js == null) {
            return 0;
        }
        jiashuRepository.saveAndFlush(jiashu);
        return 1;
    }

    @Override

    public int deleteJiashuById(int id) {
        jiashuRepository.delete(id);
        return 1;
    }


    @Override
    public Laoren getLaorenById(int id) {
        return laorenRepository.findOne(id);
    }

    public User getUserById(int id) {
        return userRepository.findOne(id);
    }


    @Override
    public Jiashu getJiashuById(int id) {
        return jiashuRepository.findOne(id);
    }

    @Override

    public int saveLaoren(Laoren laoren) {
        Laoren lr = laorenRepository.saveAndFlush(laoren);
        if (lr != null) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateLaorenById(Laoren laoren) {
        Laoren lr = laorenRepository.getOne(laoren.getId());
        if (lr == null) {
            return 0;
        }
        laorenRepository.saveAndFlush(laoren);
        return 1;
    }

    @Override
    public int updateLaorenTypeById(int type, int id) {
        Laoren lr = laorenRepository.getOne(id);
        if (lr == null) {
            return 0;
        }
        return laorenRepository.updateTypeById(type, id);
    }

    @Override

    public int saveUser(User user) {
        User ur = userRepository.saveAndFlush(user);
        if (ur != null) {
            return 1;
        }
        return 0;
    }

    @Override

    public int updateUserById(User user) {
        User ur = userRepository.getOne(user.getId());
        if (ur == null) {
            return 0;
        }
        userRepository.saveAndFlush(user);
        return 1;
    }

    @Override

    public int deleteLaorenById(int id) {
        laorenRepository.delete(id);
        return 1;
    }

    @Override

    public int deleteUserById(int id) {
        userRepository.delete(id);
        return 1;
    }
}
