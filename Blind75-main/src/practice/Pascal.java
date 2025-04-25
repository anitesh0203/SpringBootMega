package practice;

import java.util.ArrayList;
import java.util.List;

public class Pascal {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        if(numRows==1) {
            return ans;
        }
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        ans.add(second);

        if(numRows==2) {
            return ans;
        }
        for (int i=2;i<numRows;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j=1;j<=i-1;j++) {
                list.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Pascal pascal = new Pascal();
        System.out.println(pascal.generate(5));
    }

}
