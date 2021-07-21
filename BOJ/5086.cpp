#include <iostream>

using namespace std;
typedef long long ll;

void solve ();

int n1, n2;

int main() {

    while (true){

        cin >> n1 >> n2;
        if (n1==0 && n2==0) break;
        solve();

    }

}

void solve () {

    if (n1%n2==0) cout << "multiple";
    else if (n2%n1==0) cout << "factor";
    else cout << "neither";
    cout << "\n";

}
