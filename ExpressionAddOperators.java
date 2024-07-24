class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void recurse(String num, int target, int index, long calc, long tail, StringBuilder path) {
        // base
        if(index == num.length()) {
            if(calc == target) {
                result.add(path.toString());
            }
        }

        // logic
        for(int i = index; i < num.length(); i++) {
            if(num.charAt(index) == '0' && i != index) {
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            int le = path.length();
            if(index == 0) {
                recurse(num, target, i + 1, curr, curr, path.append(curr));
                path.setLength(le);
            } else {
                // +
                recurse(num, target, i + 1, calc + curr, +curr, path.append("+").append(curr));
                // path.delete(path.length() - 3, path.length() - 1);
                path.setLength(le);
                // -
                recurse(num, target, i + 1, calc - curr, -curr, path.append("-").append(curr));
                // path.delete(path.length() - 3, path.length() - 1);
                path.setLength(le);
                // *
                recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path.append("*").append(curr));
                // path.delete(path.length() - 3, path.length() - 1);
                path.setLength(le);
            }
        }
    }
}
