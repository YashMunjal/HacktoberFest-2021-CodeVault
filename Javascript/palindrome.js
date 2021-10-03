const isPalindrome = (string) => {
    if (string == string.split('').reverse().join('')) {
        return true;
    }
    else {
        return false;
    }
}

module.exports = { isPalindrome }
