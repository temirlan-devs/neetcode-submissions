class Solution {
    public String simplifyPath(String path) {

        // O(n), where n is the number of characters in path
        String[] patharr = path.split("/");

        Stack<String> stack = new Stack<>(); // Space complexity: approximately O(n), because it is just the same characters in path without some junk

        // O(m) where m is the number of strings in patharr 
        for (String p : patharr) {
            // O(2) -> O(1)
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            // O(1)
            else if (!p.equals(".") && !p.equals(""))
                stack.push(p);
        }

        // String.join - time complexity: O(n), space complexity: O(n), where n is the number of characters in final joined string. where n is the number of characters in patharr. In fact, stack holds n characters without some junk, but approximately we count it as O(n)
        // and since we do "/" + the resulting joined string -> O(n + 1) + O(n)) in total -> O(n)
        return "/" + String.join("/", stack); 
    }
}

// Time complexity: O(n)
// Space complexity: O(n)

/*

Test 

Case 1:

/Desktop/temirlan

patharr["", Desktop, temirlan]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

return /Desktop/temirlan

Case 2
/Desktop/temirlan/..

patharr["", Desktop, temirlan, ..]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

for ..
s -> Desktop

return /Desktop


Case 3:
/Desktop///temirlan//

patharr["", Desktop, "", "", temirlan]

for ""

for Desktop
s -> Desktop

for ""
for ""

for temirlan
s -> Desktop, temirlan


return /Desktop/temirlan

Case 4:

/Desktop/temirlan/...

patharr["", Desktop, temirlan, ...]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

for ...
s -> Desktop, temirlan, ...

return /Desktop/temirlan/...

Case 5:
/Desktop/temirlan///france//photos/./iphone//..///...////

patharr[Desktop, temirlan, "", "", france, "", photos, ., iphone, "", .., "", "", ...]

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

for ""
for ""

for france 
s -> Desktop, temirlan, france

for ""

for photos 
s -> Desktop, temirlan, france, photos

for .

for iPhone
s -> Desktop, temirlan, france, photos, iphone

for ""

for ..
s -> Desktop, temirlan, france, photos


for ""
for ""

for ...
s -> Desktop, temirlan, france, photos, ...

return /Desktop/temirlan/france/photos/...

Case 6:
/

patharr []

sb -> /
return /

Case 7:
desktop

patharr["desktop"]

for desktop
s -> desktop

return /desktop

Case 8:
/../
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] patharr = path.split("/");

        for (String p : patharr) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();}
            else if (!p.equals(".") && !p.equals(""))
                stack.push(p);
        }

        return "/" + String.join("/", stack);
    }
}

/*

Test 

Case 1:

/Desktop/temirlan

patharr["", Desktop, temirlan]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

return /Desktop/temirlan

Case 2
/Desktop/temirlan/..

patharr["", Desktop, temirlan, ..]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

for ..
s -> Desktop

return /Desktop


Case 3:
/Desktop///temirlan//

patharr["", Desktop, "", "", temirlan]

for ""

for Desktop
s -> Desktop

for ""
for ""

for temirlan
s -> Desktop, temirlan


return /Desktop/temirlan

Case 4:

/Desktop/temirlan/...

patharr["", Desktop, temirlan, ...]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

for ...
s -> Desktop, temirlan, ...

return /Desktop/temirlan/...

Case 5:
/Desktop/temirlan///france//photos/./iphone//..///...////

patharr["", Desktop, temirlan, "", "", france, "", photos, ., iphone, "", .., "", "", ...]

for ""

for Desktop
s -> Desktop

for temirlan
s -> Desktop, temirlan

for ""
for ""

for france 
s -> Desktop, temirlan, france

for ""

for photos 
s -> Desktop, temirlan, france, photos

for .

for iPhone
s -> Desktop, temirlan, france, photos, iphone

for ""

for ..
s -> Desktop, temirlan, france, photos


for ""
for ""

for ...
s -> Desktop, temirlan, france, photos, ...

return /Desktop/temirlan/france/photos/...

Case 6:
/

patharr []

sb -> /
return /

Case 7:
desktop

patharr["desktop"]

for desktop
s -> desktop

return /desktop

Case 8:
/../

patharr = ["", ..]

for ""
for ..

return /




*/