# CS210X-Facebuk
Charan Sankaran, Aditya Hoque, Nils Backe

For our class structure we decided to use an over arching Item class that is extended by the LivingEntity,
Possession, and Moment classes. The LivingEntity class is then extended by the Person and Pet classes.

We decided to use an overarching Item class because all items have a name and image instance variable and
an equals method. Since the equals method only requires the name of the two objects to be the same and we
can assume a Person and Pet don't have the same name, the equals method is the same for all 4 classes.

We then also decided to use a LivingEntity class because both the Person and Pet classes share instance
variables and many identical methods. There are also many places where there is a list of pets and people,
and the LivingEntity object can be used, for example in the participants list of every moment.

We were also thinking about including an Ownable class that would be extended by both Pet and Possession,
but the Pet class cannot have two super classes and there is only one simple shared method, so the code
duplication is minimal even even without an Ownable class. Making an interface called Ownable would not 
reduce code redundancy.
