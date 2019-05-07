package ru.vipusk.model;


public class User extends AbstractNameEntity {

      private boolean        isVotingToDey;

       public boolean isNew(){
             return isVotingToDey;
       }

     public User(Integer id, String name) {
            super(id, name);
      }

      public boolean isVotingToDey() {
            return isVotingToDey;
      }

      public void setVotingToDey(boolean votingToDey) {
            isVotingToDey = votingToDey;
      }




}
