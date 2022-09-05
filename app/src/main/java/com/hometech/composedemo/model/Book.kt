package com.hometech.composedemo.model

data class Book(
    val id: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val description: String,
    val publisher: String,
    val publisherDate: String,
    val images: List<String>
)

fun getAllBooks(): List<Book> {
    return listOf<Book>(
        Book(
            id = "1GxXGDwAAQBAJ",
            title = "Floret Farm's A Year in Flowers",
            subtitle = "Designing Gorgeous Arrangements for Every Season",
            author = "Erin Benzakein",
            description = "Learn how to buy, style, and present seasonal flower arrangements for every occasion. With sections on tools, flower care, and design techniques, Floret Farm's A Year in Flowers presents all the secrets to arranging garden-fresh bouquets. Featuring expert advice from Erin Benzakein, world-renowned flower farmer, floral designer, and bestselling author of Floret Farm: Cut Flower Garden, this book is a gorgeous and comprehensive guide to everything you need to make your own incredible arrangements all year long, whether harvesting flowers from the backyard or shopping for blooms at the market. • Includes an A–Z flower guide with photos and care tips for more than 200 varieties. • Simple-to-follow advice on flower care, material selection, and essential design techniques • More than 25 how-to projects, including magnificent centerpieces, infinitely giftable posies, festive wreaths, and breathtaking bridal bouquets Floret Farm's A Year in Flowers offers advice on every phase of working with cut flowers—including gardening, buying, caring for, and arranging fresh flowers. Brimming with indispensable tips and hundreds of vibrant photographs, this book is an invitation to live a flower-filled life and perfect for anyone who loves flowers. • The definitive guide to flower arranging from the biggest star in the farm-to-centerpiece movement • Perfect for flower lovers, avid and novice gardeners, floral designers, wedding planners, florists, small farmers, stylists, designers, crafters, and those passionate about the local floral movement • For those who loved Floret Farm's Cut Flower Garden by Erin Benzakein, The Flower Recipe Book by Alethea Harampolis, Seasonal Flower Arranging by Ariella Chezar, and The Flower Chef by Carly Cylinder",
            publisher = "Chronicle Books",
            publisherDate = "2020-02-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "2WVLXDwAAQBAJ",
            title = "The Flower Book",
            subtitle = "Let the Beauty of Each Bloom Speak for Itself",
            author = "Rachel Siegfried",
            description = "The Flower Book explores 60 flowers, bloom-by-bloom in stunning portraiture. Lush macrophotography allows readers to see the details of each featured flower up close, from the amaryllis in spring, snapdragon in summer, and dahlia in fall to tropical wonders such as orchids and more. Intimate portraits of each flower include quick-reference profiles with tips for choosing the best blooms, care for cut stems, arranging recommendations, colors, shapes, and even growing tips to transform the home, from yard to tabletop. Gorgeous photographs throughout spotlight 30 sample floral arrangements that show how to design and build custom floral arrangements using featured blooms. Plus, a step-by-step techniques section walks beginners through the basics of foliage and fillers, bouquets, and arrangements to make this book as practical as it is beautiful. The Flower Book celebrates all the wonderful qualities of flowers-their sheer beauty, infinite variety, and power to evoke admiration-bloom by exquisite bloom.",
            publisher = "Penguin",
            publisherDate = "2017-02-07",
            images = listOf<String>(
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "3QZAtEAAAQBAJ",
            title = "Growing Flowers",
            subtitle = "Everything You Need to Know About Planting, Tending, Harvesting and Arranging Beautiful Blooms",
            author = "Niki Irving",
            description = "Learn How to Grow Flowering Plants “Anyone wanting to get started with a flower garden will find plenty of expert guidance here.” ―Publishers Weekly #1 Best Seller in Annual Flowers Gardening, Bulb Flower Gardening, and Perennial Gardening. In the mountains of Asheville, NC, Niki Irving’s boutique flower farm grows specially cut, mountain-fresh flowers with sustainable, natural practices. Now, she brings her organic gardening techniques to your home, helping you grow, harvest, and arrange lush, seasonally inspired flowers. Revel in flowering plants. This beautifully photographed book features simple, and engaging know-how enabling you to grow, harvest, and arrange a cutting garden of flowers. An instructional guide to gardening for beginners or if you’re looking to hone your botanical skills, Growing Flowers teaches everything from caring for a cut flower garden to making simple-yet-gorgeous flower arrangements and botanical bouquets. An indispensable gardening guide for homebody horticulturists and floral foragers. A flower book with a whimsical twist, Growing Flowers is a go-to reference for those new to herb and flower gardening. Discover flower arranging techniques using blooms, greenery, and even artichokes, vines and berries. Learn about tools of the trade. Get down and dirty with dirt, seasonal rotation, starting from seeds and/or seedlings, and more. Inside find: • Explanations of soil types and soil preparations • A list of seasonal flowers such as peonies or garden roses for the spring and sunflowers and dahlias for the summer and fall • Basic knowledge to create flower bouquets that include things like sprigs of greenery and even attractive weeds Growing Flowers is a wonderful addition to any collection of garden books. If you’re looking for gardening gifts for gardeners or enjoy flowering plant books and flower books like Floret Farms Cut Flower Garden book, Floret Farm's A Year in Flowers, or The Flower Gardener's Bible, you’ll love Growing Flowers.",
            publisher = "Mango Media Inc.",
            publisherDate = "2021-05-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=QZAtEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "4VuVuDQAAQBAJ",
            title = "Plants and Flowers",
            subtitle = "1,761 Illustrations for Artists and Designers",
            author = "William K. Chapman",
            description = "ffers scientifically accurate, copyright-free illustrations of hundreds of plants and flowers from around the world",
            publisher = "Courier Corporation",
            publisherDate = "1992-09-08",
            images = listOf<String>(
                "https://books.google.com/books/content?id=VuVuDQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "5yk9ZEAAAQBAJ",
            title = "All Good People Here",
            subtitle = "A Novel",
            author = "Ashley Flowers",
            description = "#1 NEW YORK TIMES BESTSELLER • In the propulsive debut novel from the host of the #1 true crime podcast Crime Junkie, a journalist uncovers her hometown’s dark secrets when she becomes obsessed with the unsolved murder of her childhood neighbor—and the disappearance of another girl twenty years later. You can’t ever know for sure what happens behind closed doors. Everyone from Wakarusa, Indiana, remembers the infamous case of January Jacobs, who was discovered in a ditch hours after her family awoke to find her gone. Margot Davies was six at the time, the same age as January—and they were next-door neighbors. In the twenty years since, Margot has grown up, moved away, and become a big-city journalist. But she’s always been haunted by the feeling that it could’ve been her. And the worst part is, January’s killer has never been brought to justice. When Margot returns home to help care for her uncle after he is diagnosed with early-onset dementia, she feels like she’s walked into a time capsule. Wakarusa is exactly how she remembers—genial, stifled, secretive. Then news breaks about five-year-old Natalie Clark from the next town over, who’s gone missing under circumstances eerily similar to January’s. With all the old feelings rushing back, Margot vows to find Natalie and to solve January’s murder once and for all. But the police, Natalie’s family, the townspeople—they all seem to be hiding something. And the deeper Margot digs into Natalie’s disappearance, the more resistance she encounters, and the colder January’s case feels. Could January’s killer still be out there? Is it the same person who took Natalie? And what will it cost to finally discover what truly happened that night twenty years ago? Twisty, chilling, and intense, All Good People Here is a searing tale that asks: What are your neighbors capable of when they think no one is watching?",
            publisher = "Bantam",
            publisherDate = "2022-07-16",
            images = listOf<String>(
                "https://books.google.com/books/content?id=yk9ZEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "6GgBwAAQBAJ",
            title = "Sidewalk Flowers",
            subtitle = "Designing Gorgeous Arrangements for Every Season",
            author = "JonArno Lawson",
            description = "Winner of the Governor General's Literary Award for Children's Illustrated Book A New York Times Best Illustrated Children's Book of the Year In this wordless picture book, a little girl collects wildflowers while her distracted father pays her little attention. Each flower becomes a gift, and whether the gift is noticed or ignored, both giver and recipient are transformed by their encounter. “Written” by award-winning poet JonArno Lawson and brought to life by illustrator Sydney Smith, Sidewalk Flowers is an ode to the importance of small things, small people and small gestures. Correlates to the Common Core State Standards in English Language Arts: CCSS.ELA-LITERACY.RL.1.7 Use illustrations and details in a story to describe its characters, setting, or events.",
            publisher = "Groundwood Books Ltd",
            publisherDate = "2015-03-25",
            images = listOf<String>(
                "https://books.google.com/books/content?id=7-GgBwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            ),

            ),
        Book(
            id = "7GxXGDwAAQBAJ",
            title = "Floret Farm's A Year in Flowers",
            subtitle = "Designing Gorgeous Arrangements for Every Season",
            author = "Erin Benzakein",
            description = "Learn how to buy, style, and present seasonal flower arrangements for every occasion. With sections on tools, flower care, and design techniques, Floret Farm's A Year in Flowers presents all the secrets to arranging garden-fresh bouquets. Featuring expert advice from Erin Benzakein, world-renowned flower farmer, floral designer, and bestselling author of Floret Farm: Cut Flower Garden, this book is a gorgeous and comprehensive guide to everything you need to make your own incredible arrangements all year long, whether harvesting flowers from the backyard or shopping for blooms at the market. • Includes an A–Z flower guide with photos and care tips for more than 200 varieties. • Simple-to-follow advice on flower care, material selection, and essential design techniques • More than 25 how-to projects, including magnificent centerpieces, infinitely giftable posies, festive wreaths, and breathtaking bridal bouquets Floret Farm's A Year in Flowers offers advice on every phase of working with cut flowers—including gardening, buying, caring for, and arranging fresh flowers. Brimming with indispensable tips and hundreds of vibrant photographs, this book is an invitation to live a flower-filled life and perfect for anyone who loves flowers. • The definitive guide to flower arranging from the biggest star in the farm-to-centerpiece movement • Perfect for flower lovers, avid and novice gardeners, floral designers, wedding planners, florists, small farmers, stylists, designers, crafters, and those passionate about the local floral movement • For those who loved Floret Farm's Cut Flower Garden by Erin Benzakein, The Flower Recipe Book by Alethea Harampolis, Seasonal Flower Arranging by Ariella Chezar, and The Flower Chef by Carly Cylinder",
            publisher = "Chronicle Books",
            publisherDate = "2020-02-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "8WVLXDwAAQBAJ",
            title = "The Flower Book",
            subtitle = "Let the Beauty of Each Bloom Speak for Itself",
            author = "Rachel Siegfried",
            description = "The Flower Book explores 60 flowers, bloom-by-bloom in stunning portraiture. Lush macrophotography allows readers to see the details of each featured flower up close, from the amaryllis in spring, snapdragon in summer, and dahlia in fall to tropical wonders such as orchids and more. Intimate portraits of each flower include quick-reference profiles with tips for choosing the best blooms, care for cut stems, arranging recommendations, colors, shapes, and even growing tips to transform the home, from yard to tabletop. Gorgeous photographs throughout spotlight 30 sample floral arrangements that show how to design and build custom floral arrangements using featured blooms. Plus, a step-by-step techniques section walks beginners through the basics of foliage and fillers, bouquets, and arrangements to make this book as practical as it is beautiful. The Flower Book celebrates all the wonderful qualities of flowers-their sheer beauty, infinite variety, and power to evoke admiration-bloom by exquisite bloom.",
            publisher = "Penguin",
            publisherDate = "2017-02-07",
            images = listOf<String>(
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "9QZAtEAAAQBAJ",
            title = "Growing Flowers",
            subtitle = "Everything You Need to Know About Planting, Tending, Harvesting and Arranging Beautiful Blooms",
            author = "Niki Irving",
            description = "Learn How to Grow Flowering Plants “Anyone wanting to get started with a flower garden will find plenty of expert guidance here.” ―Publishers Weekly #1 Best Seller in Annual Flowers Gardening, Bulb Flower Gardening, and Perennial Gardening. In the mountains of Asheville, NC, Niki Irving’s boutique flower farm grows specially cut, mountain-fresh flowers with sustainable, natural practices. Now, she brings her organic gardening techniques to your home, helping you grow, harvest, and arrange lush, seasonally inspired flowers. Revel in flowering plants. This beautifully photographed book features simple, and engaging know-how enabling you to grow, harvest, and arrange a cutting garden of flowers. An instructional guide to gardening for beginners or if you’re looking to hone your botanical skills, Growing Flowers teaches everything from caring for a cut flower garden to making simple-yet-gorgeous flower arrangements and botanical bouquets. An indispensable gardening guide for homebody horticulturists and floral foragers. A flower book with a whimsical twist, Growing Flowers is a go-to reference for those new to herb and flower gardening. Discover flower arranging techniques using blooms, greenery, and even artichokes, vines and berries. Learn about tools of the trade. Get down and dirty with dirt, seasonal rotation, starting from seeds and/or seedlings, and more. Inside find: • Explanations of soil types and soil preparations • A list of seasonal flowers such as peonies or garden roses for the spring and sunflowers and dahlias for the summer and fall • Basic knowledge to create flower bouquets that include things like sprigs of greenery and even attractive weeds Growing Flowers is a wonderful addition to any collection of garden books. If you’re looking for gardening gifts for gardeners or enjoy flowering plant books and flower books like Floret Farms Cut Flower Garden book, Floret Farm's A Year in Flowers, or The Flower Gardener's Bible, you’ll love Growing Flowers.",
            publisher = "Mango Media Inc.",
            publisherDate = "2021-05-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=QZAtEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "10GxXGDwAAQBAJ",
            title = "Floret Farm's A Year in Flowers",
            subtitle = "Designing Gorgeous Arrangements for Every Season",
            author = "Erin Benzakein",
            description = "Learn how to buy, style, and present seasonal flower arrangements for every occasion. With sections on tools, flower care, and design techniques, Floret Farm's A Year in Flowers presents all the secrets to arranging garden-fresh bouquets. Featuring expert advice from Erin Benzakein, world-renowned flower farmer, floral designer, and bestselling author of Floret Farm: Cut Flower Garden, this book is a gorgeous and comprehensive guide to everything you need to make your own incredible arrangements all year long, whether harvesting flowers from the backyard or shopping for blooms at the market. • Includes an A–Z flower guide with photos and care tips for more than 200 varieties. • Simple-to-follow advice on flower care, material selection, and essential design techniques • More than 25 how-to projects, including magnificent centerpieces, infinitely giftable posies, festive wreaths, and breathtaking bridal bouquets Floret Farm's A Year in Flowers offers advice on every phase of working with cut flowers—including gardening, buying, caring for, and arranging fresh flowers. Brimming with indispensable tips and hundreds of vibrant photographs, this book is an invitation to live a flower-filled life and perfect for anyone who loves flowers. • The definitive guide to flower arranging from the biggest star in the farm-to-centerpiece movement • Perfect for flower lovers, avid and novice gardeners, floral designers, wedding planners, florists, small farmers, stylists, designers, crafters, and those passionate about the local floral movement • For those who loved Floret Farm's Cut Flower Garden by Erin Benzakein, The Flower Recipe Book by Alethea Harampolis, Seasonal Flower Arranging by Ariella Chezar, and The Flower Chef by Carly Cylinder",
            publisher = "Chronicle Books",
            publisherDate = "2020-02-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "11WVLXDwAAQBAJ",
            title = "The Flower Book",
            subtitle = "Let the Beauty of Each Bloom Speak for Itself",
            author = "Rachel Siegfried",
            description = "The Flower Book explores 60 flowers, bloom-by-bloom in stunning portraiture. Lush macrophotography allows readers to see the details of each featured flower up close, from the amaryllis in spring, snapdragon in summer, and dahlia in fall to tropical wonders such as orchids and more. Intimate portraits of each flower include quick-reference profiles with tips for choosing the best blooms, care for cut stems, arranging recommendations, colors, shapes, and even growing tips to transform the home, from yard to tabletop. Gorgeous photographs throughout spotlight 30 sample floral arrangements that show how to design and build custom floral arrangements using featured blooms. Plus, a step-by-step techniques section walks beginners through the basics of foliage and fillers, bouquets, and arrangements to make this book as practical as it is beautiful. The Flower Book celebrates all the wonderful qualities of flowers-their sheer beauty, infinite variety, and power to evoke admiration-bloom by exquisite bloom.",
            publisher = "Penguin",
            publisherDate = "2017-02-07",
            images = listOf<String>(
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "12QZAtEAAAQBAJ",
            title = "Growing Flowers",
            subtitle = "Everything You Need to Know About Planting, Tending, Harvesting and Arranging Beautiful Blooms",
            author = "Niki Irving",
            description = "Learn How to Grow Flowering Plants “Anyone wanting to get started with a flower garden will find plenty of expert guidance here.” ―Publishers Weekly #1 Best Seller in Annual Flowers Gardening, Bulb Flower Gardening, and Perennial Gardening. In the mountains of Asheville, NC, Niki Irving’s boutique flower farm grows specially cut, mountain-fresh flowers with sustainable, natural practices. Now, she brings her organic gardening techniques to your home, helping you grow, harvest, and arrange lush, seasonally inspired flowers. Revel in flowering plants. This beautifully photographed book features simple, and engaging know-how enabling you to grow, harvest, and arrange a cutting garden of flowers. An instructional guide to gardening for beginners or if you’re looking to hone your botanical skills, Growing Flowers teaches everything from caring for a cut flower garden to making simple-yet-gorgeous flower arrangements and botanical bouquets. An indispensable gardening guide for homebody horticulturists and floral foragers. A flower book with a whimsical twist, Growing Flowers is a go-to reference for those new to herb and flower gardening. Discover flower arranging techniques using blooms, greenery, and even artichokes, vines and berries. Learn about tools of the trade. Get down and dirty with dirt, seasonal rotation, starting from seeds and/or seedlings, and more. Inside find: • Explanations of soil types and soil preparations • A list of seasonal flowers such as peonies or garden roses for the spring and sunflowers and dahlias for the summer and fall • Basic knowledge to create flower bouquets that include things like sprigs of greenery and even attractive weeds Growing Flowers is a wonderful addition to any collection of garden books. If you’re looking for gardening gifts for gardeners or enjoy flowering plant books and flower books like Floret Farms Cut Flower Garden book, Floret Farm's A Year in Flowers, or The Flower Gardener's Bible, you’ll love Growing Flowers.",
            publisher = "Mango Media Inc.",
            publisherDate = "2021-05-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=QZAtEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ), Book(
            id = "13yk9ZEAAAQBAJ",
            title = "All Good People Here",
            subtitle = "A Novel",
            author = "Ashley Flowers",
            description = "#1 NEW YORK TIMES BESTSELLER • In the propulsive debut novel from the host of the #1 true crime podcast Crime Junkie, a journalist uncovers her hometown’s dark secrets when she becomes obsessed with the unsolved murder of her childhood neighbor—and the disappearance of another girl twenty years later. You can’t ever know for sure what happens behind closed doors. Everyone from Wakarusa, Indiana, remembers the infamous case of January Jacobs, who was discovered in a ditch hours after her family awoke to find her gone. Margot Davies was six at the time, the same age as January—and they were next-door neighbors. In the twenty years since, Margot has grown up, moved away, and become a big-city journalist. But she’s always been haunted by the feeling that it could’ve been her. And the worst part is, January’s killer has never been brought to justice. When Margot returns home to help care for her uncle after he is diagnosed with early-onset dementia, she feels like she’s walked into a time capsule. Wakarusa is exactly how she remembers—genial, stifled, secretive. Then news breaks about five-year-old Natalie Clark from the next town over, who’s gone missing under circumstances eerily similar to January’s. With all the old feelings rushing back, Margot vows to find Natalie and to solve January’s murder once and for all. But the police, Natalie’s family, the townspeople—they all seem to be hiding something. And the deeper Margot digs into Natalie’s disappearance, the more resistance she encounters, and the colder January’s case feels. Could January’s killer still be out there? Is it the same person who took Natalie? And what will it cost to finally discover what truly happened that night twenty years ago? Twisty, chilling, and intense, All Good People Here is a searing tale that asks: What are your neighbors capable of when they think no one is watching?",
            publisher = "Bantam",
            publisherDate = "2022-07-16",
            images = listOf<String>(
                "https://books.google.com/books/content?id=yk9ZEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "14GgBwAAQBAJ",
            title = "Sidewalk Flowers",
            subtitle = "Designing Gorgeous Arrangements for Every Season",
            author = "JonArno Lawson",
            description = "Winner of the Governor General's Literary Award for Children's Illustrated Book A New York Times Best Illustrated Children's Book of the Year In this wordless picture book, a little girl collects wildflowers while her distracted father pays her little attention. Each flower becomes a gift, and whether the gift is noticed or ignored, both giver and recipient are transformed by their encounter. “Written” by award-winning poet JonArno Lawson and brought to life by illustrator Sydney Smith, Sidewalk Flowers is an ode to the importance of small things, small people and small gestures. Correlates to the Common Core State Standards in English Language Arts: CCSS.ELA-LITERACY.RL.1.7 Use illustrations and details in a story to describe its characters, setting, or events.",
            publisher = "Groundwood Books Ltd",
            publisherDate = "2015-03-25",
            images = listOf<String>(
                "https://books.google.com/books/content?id=7-GgBwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            ),

            ),
        Book(
            id = "15GxXGDwAAQBAJ",
            title = "Floret Farm's A Year in Flowers",
            subtitle = "Designing Gorgeous Arrangements for Every Season",
            author = "Erin Benzakein",
            description = "Learn how to buy, style, and present seasonal flower arrangements for every occasion. With sections on tools, flower care, and design techniques, Floret Farm's A Year in Flowers presents all the secrets to arranging garden-fresh bouquets. Featuring expert advice from Erin Benzakein, world-renowned flower farmer, floral designer, and bestselling author of Floret Farm: Cut Flower Garden, this book is a gorgeous and comprehensive guide to everything you need to make your own incredible arrangements all year long, whether harvesting flowers from the backyard or shopping for blooms at the market. • Includes an A–Z flower guide with photos and care tips for more than 200 varieties. • Simple-to-follow advice on flower care, material selection, and essential design techniques • More than 25 how-to projects, including magnificent centerpieces, infinitely giftable posies, festive wreaths, and breathtaking bridal bouquets Floret Farm's A Year in Flowers offers advice on every phase of working with cut flowers—including gardening, buying, caring for, and arranging fresh flowers. Brimming with indispensable tips and hundreds of vibrant photographs, this book is an invitation to live a flower-filled life and perfect for anyone who loves flowers. • The definitive guide to flower arranging from the biggest star in the farm-to-centerpiece movement • Perfect for flower lovers, avid and novice gardeners, floral designers, wedding planners, florists, small farmers, stylists, designers, crafters, and those passionate about the local floral movement • For those who loved Floret Farm's Cut Flower Garden by Erin Benzakein, The Flower Recipe Book by Alethea Harampolis, Seasonal Flower Arranging by Ariella Chezar, and The Flower Chef by Carly Cylinder",
            publisher = "Chronicle Books",
            publisherDate = "2020-02-11",
            images = listOf<String>(
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            )
        ),
        Book(
            id = "16WVLXDwAAQBAJ",
            title = "The Flower Book",
            subtitle = "Let the Beauty of Each Bloom Speak for Itself",
            author = "Rachel Siegfried",
            description = "The Flower Book explores 60 flowers, bloom-by-bloom in stunning portraiture. Lush macrophotography allows readers to see the details of each featured flower up close, from the amaryllis in spring, snapdragon in summer, and dahlia in fall to tropical wonders such as orchids and more. Intimate portraits of each flower include quick-reference profiles with tips for choosing the best blooms, care for cut stems, arranging recommendations, colors, shapes, and even growing tips to transform the home, from yard to tabletop. Gorgeous photographs throughout spotlight 30 sample floral arrangements that show how to design and build custom floral arrangements using featured blooms. Plus, a step-by-step techniques section walks beginners through the basics of foliage and fillers, bouquets, and arrangements to make this book as practical as it is beautiful. The Flower Book celebrates all the wonderful qualities of flowers-their sheer beauty, infinite variety, and power to evoke admiration-bloom by exquisite bloom.",
            publisher = "Penguin",
            publisherDate = "2017-02-07",
            images = listOf<String>(
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                "https://books.google.com/books/content?id=WVLXDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
            )
        )
    )
}
