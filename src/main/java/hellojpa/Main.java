package hellojpa;

import entity.Member;
import entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");

        // factory, entityManager, transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HS");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ex = em.getTransaction();

        // transaction start
        ex.begin();

        try {
            Team team = new Team();
            team.setName("A");
            em.persist(team);

            Member member = new Member();
            member.setName("Hello");

            team.getMembers().add(member);
            member.setTeam(team);
            em.persist(member);


            // console에서 조인쿼리 확인 가능
            em.flush();
            em.clear();

            // ----------------------------------------

            Member findMember = em.find(Member.class, member.getId());

            em.clear();

            Team findTeam = findMember.getTeam();
            findTeam.getName();
            System.out.println("findTeam: " + findTeam);

            ex.commit();
        } catch (Exception e) {
            e.printStackTrace();
            ex.rollback();
        } finally {
            em.close();
        }

        em.close();
        emf.close();

    }
}
