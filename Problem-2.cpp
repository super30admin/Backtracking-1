class Solution
{
public:
    vector<string> result;
    vector<string> addOperators(string num, int target)
    {
        if (num.empty() || num.size() == 0)
        {
            return {};
        }

        result = {};
        // input string, target, index, calculated value, string formed
        recurse(num, target, 0, 0, 0, "");
        return result;
    }

    void recurse(string num, int target, int index, long calc, long tail, string path)
    {
        // base
        if (index == num.size())
        {
            if (calc == target)
            {
                result.push_back(path);
            }
            return;
        }

        // logic
        for (int i = index; i < num.size(); i++)
        {

            if (num[index] == '0' && i > index)
                break;

            long curr = stol(num.substr(index, i - index + 1));

            if (index == 0)
            {
                recurse(num, target, i + 1, curr, curr, path + to_string(curr));
            }
            else
            {
                // + operator
                recurse(num, target, i + 1, calc + curr, +curr, path + "+" + to_string(curr));

                // - operator
                recurse(num, target, i + 1, calc - curr, -curr, path + "-" + to_string(curr));

                // * operator
                recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + to_string(curr));
            }
        }
    }
};