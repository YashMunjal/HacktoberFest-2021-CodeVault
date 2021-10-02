/*
 ? Given a string,
 ? find the length of the longest substring without repeating characters.
 */
var longestSubstring = function (myString) {
    var maxSubLength = 0;
    if (myString.length <= 1)
        return myString.length;
    for (var p = 0; p < myString.length; p++) {
        var tempMap = {};
        var tempSubLength = 0;
        for (var q = p; q < myString.length; q++) {
            var currentCharacter = myString[q];
            if (!tempMap[currentCharacter]) {
                tempSubLength++;
                tempMap[currentCharacter] = true;
                maxSubLength = Math.max(tempSubLength, maxSubLength);
            }
            else {
                break;
            }
        }
    }
    return maxSubLength;
};
var longestSubstringOpt = function (s) {
    if (s.length <= 1)
        return s.length;
    var seenChars = new Map();
    var left = 0, longest = 0;
    for (var right = 0; right < s.length; right++) {
        var currentChar = s[right];
        var prevSeenChar = seenChars.get(currentChar);
        if (prevSeenChar >= left) {
            left = prevSeenChar + 1;
        }
        seenChars.set(currentChar, right);
        longest = Math.max(longest, right - left + 1);
    }
    return longest;
};
console.time('maxSubLength');
console.log(longestSubstring('abcabcbb'));
console.timeEnd('maxSubLength');
console.time('maxSubLengthOpt');
console.log(longestSubstringOpt('abcabcbb'));
console.timeEnd('maxSubLengthOpt');
