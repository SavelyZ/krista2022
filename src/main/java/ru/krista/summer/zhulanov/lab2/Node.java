package ru.krista.summer.zhulanov.lab2;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {

       private UUID ID;
    private String Name;
     private List<Node> ChildList_ = new ArrayList<>();

    public Node(UUID ID, String Name) {
          this.ID = ID;
         this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public Node addChild(UUID randomUUID, String Child_now1) {     //добавляет одного потомка
            Node Child_now = new Node(randomUUID, Child_now1);
              this.ChildList_.add(Child_now);
            return Child_now;
    }
    public Node findChild(String Name) {       //ищет потомка с переданным именем
        for (Node Child_now : ChildList_) {
              if (Child_now.getName() == Name)
                return Child_now;
        }
        return null;
    }
    public void deleteChildNode(String Name) {     //удаляет узел
         for (Node Child_now : ChildList_) {
             if (Child_now.getName() == Name) ChildList_.remove(Child_now);
        }
    }

    public void printNodes(int level) {     //выводит все узлы дерева
        for (Node Child_now : ChildList_) {
                     String spaces ="";
            for (int i=0; i<level; i++)
                spaces += " ";
            System.out.println(spaces + "- " + Child_now.getName());
                    Child_now.printNodes(level++);
        }
    }

    public void reNameNode(String Name) {
                this.Name = Name;
    }
}
