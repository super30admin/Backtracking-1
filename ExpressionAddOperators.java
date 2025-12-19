import java.util.ArrayList;
import java.util.List;  
class ExpressionAddOperators {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        addOperatorHelper(num, target, 0, new StringBuilder(),  0l, 0l);
        return result;
    }

    private void addOperatorHelper(String num, int target, int pivot, StringBuilder path, long cal, long tail)
    {
        // base
        // we have to iclude all digits
        if(pivot == num.length())
        {
            if(cal == target)
            {
                result.add(path.toString());
            }
            return;
        }

        // logic
        // action
        for(int i = pivot; i < num.length(); i++)
        {
            // handle leading 0 cases, and not include them, we dont need '05'
            if(pivot != i && num.charAt(pivot) == '0') continue;
            long curr = Long.parseLong(num.substring(pivot, i+1)); // pivot to i, include i - substring
            int le = path.length();
            // recurse
            if(0 == pivot) // no need of operators here - for 1, 12, 123, 1234 cases in first level
            {
                path.append(curr);
                addOperatorHelper(num, target, i+1, path, curr, curr);
                path.setLength(le);
            }
            // backtrack - the operations 
            else
            {
                // +
                path.append("+").append(curr);
                addOperatorHelper(num, target, i+1, path, cal+curr, curr);
                path.setLength(le);
                // -
                path.append("-").append(curr);
                addOperatorHelper(num, target, i+1, path, cal-curr, -curr);
                path.setLength(le);
                // *
                path.append("*").append(curr);
                addOperatorHelper(num, target, i+1, path, cal - tail + tail * curr, tail*curr);
                path.setLength(le);
            }
        }
    }
}