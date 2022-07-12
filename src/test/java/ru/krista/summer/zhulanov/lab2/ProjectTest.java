package ru.krista.summer.zhulanov.lab2;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    @Test
    public void test1(){
        assertTrue(true, "Не true");
    }

    @Test
    public void createTreeTest(){
        Node node = new Node(UUID.randomUUID(), "Root");

        assertEquals("Root", node.getName(), "Дерево не создано");
    }

    @Test
    public void findNodeTest(){
        Node root = new Node(UUID.randomUUID(), "Root");
        Node child1 = root.addChild(UUID.randomUUID(), "Child1");
        Node child2 = root.findChild("Child1");

        assertEquals(
                child2.getName(),
                "Child1",
                "Нода не была найдена"
        );
    }

    @Test
    public void addChildNodeTest(){
        Node root = new Node(UUID.randomUUID(), "Root");
        Node child1 = root.addChild(UUID.randomUUID(), "Child1.1");

        assertEquals(
            root.findChild("Child1.1").getName(),
            "Child1.1",
            "Нода не была добавлена как дочерняя"
        );
    }

    @Test
    public void delChildNodeTest(){
        Node root = new Node(UUID.randomUUID(), "Root");
        Node child1 = root.addChild(UUID.randomUUID(), "Child1");
        Node child2 = root.addChild(UUID.randomUUID(), "Child2");
        Node child3 = root.addChild(UUID.randomUUID(), "Child3");
        root.deleteChildNode("Child2");

        assertNull(root.findChild("Child2"), "Узел не удален");
    }

    @Test
    public void renameNodeTest(){
        Node root = new Node(UUID.randomUUID(), "Root");
        Node child = root.addChild(UUID.randomUUID(), "Child1");
        child.renameNode("Child2");

        assertEquals(
                child.getName(),
                "Child2",
                "Нода не была переименована"
        );
    }

    @Test
    public void printAllNodesTest() {
        Node root = new Node(UUID.randomUUID(), "Root");
        Node child1 = root.addChild(UUID.randomUUID(), "Child1");
        Node child2 = root.addChild(UUID.randomUUID(), "Child2");
        Node child3 = child1.addChild(UUID.randomUUID(), "Child1.1");
        Node child4 = child2.addChild(UUID.randomUUID(), "Child2.2");
        root.printNodes(0);
    }
}
