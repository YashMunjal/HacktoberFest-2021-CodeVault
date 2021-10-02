// Add two numbers represented by linked lists(GfG)
// Difficulty - Easy
//https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

class Solution
{
public:
    //Function to add two numbers represented by linked list.
    struct Node *addTwoLists(struct Node *first, struct Node *second)
    {
        // code here
        if (first == NULL)
            return second;
        if (second == NULL)
            return first;
        Node *next = NULL;
        Node *curr = first;
        Node *prev = NULL;
        int l1 = 0;
        while (curr != NULL)
        {
            next = curr->next;
            curr->next = prev;
            l1++;
            prev = curr;
            curr = next;
        }

        first = prev;
        Node *s1 = prev;

        next = NULL;
        curr = second;
        prev = NULL;
        int l2 = 0;
        while (curr != NULL)
        {
            next = curr->next;
            curr->next = prev;
            l2++;
            prev = curr;
            curr = next;
        }

        second = prev;
        Node *s2 = prev;

        if (l1 < l2)
        {
            Node *temp = s1;
            s1 = s2;
            s2 = temp;
        }
        Node *pp = NULL;
        int carry = 0;
        while (s2 != NULL)
        {
            int nnum = s1->data + s2->data + carry;
            s1->data = nnum % 10;
            carry = nnum / 10;
            pp = s1;
            s1 = s1->next;
            s2 = s2->next;
        }

        if (l1 == l2 && carry)
        {
            Node *n = new Node(carry);
            pp->next = n;
        }
        else
        {
            while (carry && s1 != NULL)
            {
                if (s1->next == NULL)
                {
                    int nnum = s1->data + carry;
                    s1->data = nnum % 10;
                    carry = nnum / 10;
                    if (carry)
                    {
                        Node *n = new Node(carry);
                        s1->next = n;
                    }
                    break;
                }
                int nnum = s1->data + carry;
                s1->data = nnum % 10;
                carry = nnum / 10;
                s1 = s1->next;
            }
        }

        if (l1 < l2)
        {
            next = NULL;
            curr = second;
            prev = NULL;

            while (curr != NULL)
            {
                next = curr->next;
                curr->next = prev;

                prev = curr;
                curr = next;
            }
            return prev;
        }
        else
        {
            next = NULL;
            curr = first;
            prev = NULL;

            while (curr != NULL)
            {
                next = curr->next;
                curr->next = prev;

                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
};
