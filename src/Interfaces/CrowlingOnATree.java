package Interfaces;

import Enums.Direction;
import Things.Tree;

public interface CrowlingOnATree {
    void climbOnTree(Tree tree, int height);
    void crowlOnTwig(Tree.Twig twig, int distance);
    void whereHang(Tree tree);

}
